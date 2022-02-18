package com.patika.paycore.Project.service;

import com.patika.paycore.Project.model.entity.Bank;
import com.patika.paycore.Project.model.dto.CustomerDto;

import java.util.List;

public interface BankService {
    List<Bank> getAllBanks();

    Bank getBank(Integer id);

    void addBank(Bank bank);

    Bank updateBank(Integer id, Bank bank);

    boolean deleteBank(Integer id);

    void addNewAccount(CustomerDto customerDto);

  //  Bank getBankByName(String bankName);
}
