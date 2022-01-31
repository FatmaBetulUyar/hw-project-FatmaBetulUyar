package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.model.Transaction;
import com.patika.paycore.Project.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    @Override
    public List<Transaction> getAllTransactions() {
        return null;
    }

    @Override
    public Transaction getTransaction(Integer id) {
        return null;
    }

    @Override
    public void addTransaction(Transaction transaction) {

    }

    @Override
    public Transaction updateTransaction(Integer id, Transaction transaction) {
        return null;
    }

    @Override
    public boolean deleteTransaction(Integer id) {
        return false;
    }
}
