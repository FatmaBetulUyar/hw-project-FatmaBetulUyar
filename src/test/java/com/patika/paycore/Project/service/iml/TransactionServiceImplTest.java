package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.InsufficientBalanceException;
import com.patika.paycore.Project.model.dto.TransactionDto;
import com.patika.paycore.Project.model.entity.Account;
import com.patika.paycore.Project.model.entity.Customer;
import com.patika.paycore.Project.model.entity.Transaction;
import com.patika.paycore.Project.model.entity.TransactionType;
import com.patika.paycore.Project.repository.TransactionRepository;
import com.patika.paycore.Project.service.CustomerService;
import com.patika.paycore.Project.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @Mock
    private CustomerService customerService;

    @Mock
    private TransactionRepository transactionRepository;


    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Test
    void addTransactionSuccessStateWithdraw() throws InsufficientBalanceException {

        TransactionDto dto=new TransactionDto(1,100.0F, TransactionType.WITHDRAW);
        Account account=new Account(1,"05545455555555",200.0F,null,null);
        Customer customer=new Customer(1,"firstname","lastname","test@gmail.com","055555555",account,null,null,null);
        Transaction transaction=new Transaction(1,TransactionType.WITHDRAW,100.0F,new Date(),"deneme",true,customer);

        when(customerService.getCustomer(1)).thenReturn(customer);
        when(transactionRepository.save(any())).thenReturn(transaction);
        Transaction result=transactionService.addTransaction(dto);

        assertEquals(100.0F,result.getCustomer().getAccount().getBalance());

    }

    @Test
    void addTransactionSuccessStateDeposit() throws InsufficientBalanceException {
        TransactionDto dto=new TransactionDto(1,100.0F, TransactionType.DEPOSIT);
        Account account=new Account(1,"05545455555555",0.0F,null,null);
        Customer customer=new Customer(1,"firstname","lastname","test@gmail.com","055555555",account,null,null,null);
        Transaction transaction=new Transaction(1,TransactionType.DEPOSIT,100.0F,new Date(),"deneme",true,customer);

        when(customerService.getCustomer(1)).thenReturn(customer);
        when(transactionRepository.save(any())).thenReturn(transaction);

        Transaction result=transactionService.addTransaction(dto);

        assertEquals(100.0F,result.getCustomer().getAccount().getBalance());

    }

    @Test
    void addTransactionFailStateCatchException(){
        TransactionDto dto=new TransactionDto(1,100.0F, TransactionType.WITHDRAW);
        Account account=new Account(1,"05545455555555",0.0F,null,null);
        Customer customer=new Customer(1,"firstname","lastname","test@gmail.com","055555555",account,null,null,null);
        Transaction transaction=new Transaction(1,TransactionType.WITHDRAW,100.0F,new Date(),"deneme",true,customer);

        when(customerService.getCustomer(1)).thenReturn(customer);

        Exception exception = assertThrows(InsufficientBalanceException.class, () -> {
             transactionService.addTransaction(dto);

        });

        String expectedMessage = "Sorry,your transaction could not be performed.You do not have enough balance in your account. ";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

}