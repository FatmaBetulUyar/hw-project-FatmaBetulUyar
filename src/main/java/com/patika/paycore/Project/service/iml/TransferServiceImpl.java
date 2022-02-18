package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.InsufficientBalanceException;
import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.*;
import com.patika.paycore.Project.model.dto.TransferDto;
import com.patika.paycore.Project.repository.RecipientRepository;
import com.patika.paycore.Project.repository.TransferRepository;
import com.patika.paycore.Project.service.RecipientService;
import com.patika.paycore.Project.service.TransferService;
import com.patika.paycore.Project.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final TransferRepository transferRepository;
    private final RecipientRepository recipientRepository;
    private final CustomerService customerService;
    private final RecipientService recipientService;
    @Override
    public List<Transfer> getAllTransfers() {
        return transferRepository.findAll();
    }

    @Override
    public Transfer getTransfer(Integer id) {
        Optional<Transfer> byId=transferRepository.findById(id);
        return byId.orElseThrow(()->new NotFoundException("Transfer"));
    }

    @Override
    public void addTransfer(TransferDto transfer) {

        Customer user= customerService.getCustomer(transfer.getUser_id());

        if(user.getAccount().getBalance() < transfer.getAmount()){
            new InsufficientBalanceException();
        }
        Customer recipient= customerService.getCustomer(transfer.getRecipient_id()) ;
        //recipient user mapper
        // user recipient olarak kaydet
        Float transactionForUser=user.getAccount().getBalance()-transfer.getAmount();
        Float transactionForRecipient=recipient.getAccount().getBalance()+transfer.getAmount();

        recipient.getAccount().setBalance(transactionForRecipient);
        user.getAccount().setBalance(transactionForUser);
        //user ve recipient veritabanına kaydedilecek

        customerService.updateCustomer(user.getId(),user);
        customerService.updateCustomer(recipient.getId(),recipient);

        Recipient recipient1=new Recipient();
        recipient1.setAccount(recipient.getAccount());
        recipient1.setEmail(recipient.getEmail());
        recipient1.setFirstName(recipient.getFirstName());
        recipient1.setLastName(recipient.getLastName());
        recipient1.setPhone(recipient.getPhone());

        recipient1=recipientService.addRecipient(recipient1);

        Transfer transfer1=new Transfer();
        transfer1.setUserTransfer(user);
        transfer1.setRecipient(recipient1);
        transfer1.setTransferDate(new Date());
        transfer1.setTransferDescription(transfer.getDescription());
        transfer1.setAmount(transfer.getAmount());
        transfer1.setIsSuccess(true);
        if(user.getAccount().getBank().getName()==recipient.getAccount().getBank().getName()){
            transfer1.setTransferType(TransferType.BETWEENACCOUNTS);
        }
        else {
            transfer1.setTransferType(TransferType.TOSOMEONE);
        }
        transferRepository.save(transfer1);


        //1.Kullanıcıyı çağır
        //2.user account çağır
        //3.user account içindeki amount kontrol et
        //4.Hesabında para varsa  recipient account çağır
        //5.user accounttan o miktarı sil
        //6.recipient accountta o miktarı arttır
        //7.Yeni bir transfer objesi oluştur
        //8.İçini doldur(tarih ..)
        //9.Transfer objesini kaydet
        // transferRepository.save(transfer);

    }

    @Override
    public Transfer updateTransfer(Integer id, Transfer transfer) {
        getTransfer(id);
        transfer.setId(id);
        return transferRepository.save(transfer);
    }

    @Override
    public boolean deleteTransfer(Integer id) {
        transferRepository.delete(getTransfer(id));
        return true;
    }
}
