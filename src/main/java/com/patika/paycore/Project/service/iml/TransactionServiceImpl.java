package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.InsufficientBalanceException;
import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.Account;
import com.patika.paycore.Project.model.Transaction;
import com.patika.paycore.Project.model.TransactionType;
import com.patika.paycore.Project.model.Customer;
import com.patika.paycore.Project.model.dto.TransactionDto;
import com.patika.paycore.Project.repository.TransactionRepository;
import com.patika.paycore.Project.service.TransactionService;
import com.patika.paycore.Project.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CustomerService customerService;
    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransaction(Integer id) {
        Optional<Transaction> byId=transactionRepository.findById(id);
        return byId.orElseThrow(()->new NotFoundException("Transaction"));
    }

    @Override
    public void addTransaction(TransactionDto transaction) throws InsufficientBalanceException {

        Customer user= customerService.getUser(transaction.getUser_id());

        if(transaction.getTransactionType()== TransactionType.WITHDRAW){
            withDraw(user,transaction.getAmount());
        }
        else {
            deposit(user,transaction.getAmount());
        }

        Transaction transaction1=new Transaction();
        transaction1.setTransactionType(transaction.getTransactionType());
        transaction1.setTransactionDescription(transaction1.getTransactionDate() + " tarihinde " + transaction.getAmount() +" Tl 'lik işlem yapılmıştır.");
        transaction1.setTransactionDate(new Date());
        transaction1.setAmount(transaction.getAmount());
        transaction1.setUserTransaction(user);
        transaction1.setIsSuccess(true);

        //Dto oluştur
        //user ı çağır
        //iki tane fonksiyon oluştur (para yatır- para çek)
        //hangi işlem olduğuna bak
        //para çekmeyse => hesap bakiyesini kontrol et
        //değilse  =>
        //user ı kaydet
        //transaction nesnesi oluştur
        //transaction bilgilerini set et
        //transaction kaydet
        transactionRepository.save(transaction1);
    }




    @Override
    public Transaction updateTransaction(Integer id, Transaction transaction) {
        getTransaction(id);
        transaction.setId(id);
        return transactionRepository.save(transaction);
    }

    @Override
    public boolean deleteTransaction(Integer id) {
        transactionRepository.delete(getTransaction(id));
        return true;
    }

    @Override
    public void withDraw(Customer user , Float amount) throws InsufficientBalanceException {

        if (user.getAccount().getBalance()<amount){
           throw new InsufficientBalanceException();
        }else {
            Float remainAmount=user.getAccount().getBalance()-amount;
            Account account=user.getAccount();
            account.setBalance(remainAmount);
            user.setAccount(account);
        }

    }

    @Override
    public void deposit(Customer user, Float amount) {
        Float totalAmount=user.getAccount().getBalance()+amount;
        Account account=user.getAccount();
        account.setBalance(totalAmount);
    }
}
