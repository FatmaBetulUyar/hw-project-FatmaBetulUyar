package com.patika.paycore.Project.service;

import com.patika.paycore.Project.exception.InsufficientBalanceException;
import com.patika.paycore.Project.model.Transaction;
import com.patika.paycore.Project.model.Customer;
import com.patika.paycore.Project.model.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();

    Transaction getTransaction(Integer id);

    void addTransaction(TransactionDto transaction) throws InsufficientBalanceException;

    Transaction updateTransaction(Integer id, Transaction transaction);

    boolean deleteTransaction(Integer id);

    void withDraw(Customer user, Float amount) throws InsufficientBalanceException;

    void deposit(Customer user, Float amount);
}
