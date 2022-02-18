package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.InsufficientBalanceException;
import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.entity.Account;
import com.patika.paycore.Project.model.entity.Transaction;
import com.patika.paycore.Project.model.entity.TransactionType;
import com.patika.paycore.Project.model.entity.Customer;
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

        Customer user= customerService.getCustomer(transaction.getUser_id());

        if(transaction.getTransactionType()== TransactionType.WITHDRAW){
            withDraw(user,transaction.getAmount());
        }
        else {
            deposit(user,transaction.getAmount());
        }

        Transaction transaction1=new Transaction();
        transaction1.setTransactionType(transaction.getTransactionType());
        transaction1.setTransactionDate(new Date());
        transaction1.setTransactionDescription(transaction1.getTransactionDate() + " tarihinde " + transaction.getAmount() +" TL 'lik işlem yapılmıştır.");
        transaction1.setAmount(transaction.getAmount());
        transaction1.setCustomer(user);
        transaction1.setIsSuccess(true);

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
