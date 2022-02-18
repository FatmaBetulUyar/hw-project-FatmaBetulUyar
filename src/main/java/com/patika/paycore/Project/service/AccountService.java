package com.patika.paycore.Project.service;

import com.patika.paycore.Project.model.Account;
import com.patika.paycore.Project.model.User;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();

    Account getAccount(Integer id);

    Account addAccount(Account account);

    Account updateAccount(Integer id, Account account);

    boolean deleteAccount(Integer id);
}
