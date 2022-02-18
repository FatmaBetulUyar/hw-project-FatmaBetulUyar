package com.patika.paycore.Project.service;

import com.patika.paycore.Project.model.Account;
import com.patika.paycore.Project.model.Bank;
import com.patika.paycore.Project.model.dto.UserDto;

import java.util.List;

public interface BankService {
    List<Bank> getAllBanks();

    Bank getBank(Integer id);

    void addBank(Bank bank);

    Bank updateBank(Integer id, Bank bank);

    boolean deleteBank(Integer id);

    void addNewAccount(UserDto userDto);

  //  Bank getBankByName(String bankName);
}
