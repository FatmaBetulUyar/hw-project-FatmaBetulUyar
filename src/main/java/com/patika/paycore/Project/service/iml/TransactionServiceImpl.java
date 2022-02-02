package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.Transaction;
import com.patika.paycore.Project.repository.TransactionRepository;
import com.patika.paycore.Project.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
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
    public void addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
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
}
