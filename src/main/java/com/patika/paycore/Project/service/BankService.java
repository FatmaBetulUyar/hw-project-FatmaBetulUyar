package com.patika.paycore.Project.service;

import com.patika.paycore.Project.model.Bank;
import com.patika.paycore.Project.model.User;

import java.util.List;

public interface BankService {
    List<Bank> getAllBanks();

    Bank getBank(Integer id);

    void addBank(Bank bank);

    Bank updateBank(Integer id, Bank bank);

    boolean deleteBank(Integer id);
}
