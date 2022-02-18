package com.patika.paycore.Project.controller;

import com.patika.paycore.Project.exception.InsufficientBalanceException;
import com.patika.paycore.Project.model.Bank;
import com.patika.paycore.Project.model.Transaction;
import com.patika.paycore.Project.model.Transfer;
import com.patika.paycore.Project.model.dto.TransactionDto;
import com.patika.paycore.Project.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping(value = "/all")
    public List<Transaction> getAll(){
        return transactionService.getAllTransactions();
    }

    @GetMapping(value = "/{id}")
    public Transaction getTransaction(@PathVariable Integer id){
        return transactionService.getTransaction(id);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> saveTransaction(@Valid @RequestBody TransactionDto transaction){
        try {
            transactionService.addTransaction(transaction);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (InsufficientBalanceException e) {
            return new ResponseEntity<>("bakiye yetersiz!",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update/{id}")
    public Transaction updateTransaction(@PathVariable Integer id, @Valid @RequestBody Transaction transaction) {
        return transactionService.updateTransaction(id,transaction);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteTransaction(@RequestParam Integer id) {
        return transactionService.deleteTransaction(id);
    }
}
