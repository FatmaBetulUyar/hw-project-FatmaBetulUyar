package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.InsufficientBalanceException;
import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.dto.TransferDto;
import com.patika.paycore.Project.model.entity.Customer;
import com.patika.paycore.Project.model.entity.Recipient;
import com.patika.paycore.Project.model.entity.Transfer;
import com.patika.paycore.Project.model.entity.TransferType;
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
    public void addTransfer(TransferDto transferDto) throws InsufficientBalanceException {

        Customer user= customerService.getCustomer(transferDto.getUser_id());

        if(user.getAccount().getBalance() < transferDto.getAmount()){
           throw  new InsufficientBalanceException();
        }
        Customer recipientCustomer= customerService.getCustomer(transferDto.getRecipient_id()) ;

        Float transactionForUser=user.getAccount().getBalance()-transferDto.getAmount();
        Float transactionForRecipient=recipientCustomer.getAccount().getBalance()+transferDto.getAmount();

        recipientCustomer.getAccount().setBalance(transactionForRecipient);
        user.getAccount().setBalance(transactionForUser);

        customerService.updateCustomer(user.getId(),user);
        customerService.updateCustomer(recipientCustomer.getId(),recipientCustomer);

        Recipient recipient=new Recipient();
        recipient.setAccount(recipientCustomer.getAccount());
        recipient.setEmail(recipientCustomer.getEmail());
        recipient.setFirstName(recipientCustomer.getFirstName());
        recipient.setLastName(recipientCustomer.getLastName());
        recipient.setPhone(recipientCustomer.getPhone());

        recipient=recipientService.addRecipient(recipient);

        Transfer transfer=new Transfer();
        transfer.setCustomer(user);
        transfer.setRecipient(recipient);
        transfer.setTransferDate(new Date());
        transfer.setTransferDescription(transferDto.getDescription());
        transfer.setAmount(transferDto.getAmount());
        transfer.setIsSuccess(true);
        if(user.getAccount().getBank().getName()==recipientCustomer.getAccount().getBank().getName()){
            transfer.setTransferType(TransferType.BETWEENACCOUNTS);
        }
        else {
            transfer.setTransferType(TransferType.TOSOMEONE);
        }
        transferRepository.save(transfer);

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
