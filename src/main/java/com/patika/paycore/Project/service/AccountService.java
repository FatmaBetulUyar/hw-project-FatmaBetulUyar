package com.patika.paycore.Project.service;

import com.patika.paycore.Project.model.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();

    Account getAccount(Integer id);

    Account addAccount(Account account);

    Account updateAccount(Integer id, Account account);

    boolean deleteAccount(Integer id);
}
