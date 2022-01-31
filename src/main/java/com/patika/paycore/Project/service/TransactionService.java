package com.patika.paycore.Project.service;

import com.patika.paycore.Project.model.Transaction;
import com.patika.paycore.Project.model.User;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();

    Transaction getTransaction(Integer id);

    void addTransaction(Transaction transaction);

    Transaction updateTransaction(Integer id, Transaction transaction);

    boolean deleteTransaction(Integer id);
}
