package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.model.Account;
import com.patika.paycore.Project.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    @Override
    public List<Account> getAllAccounts() {
        return null;
    }

    @Override
    public Account getAccount(Integer id) {
        return null;
    }

    @Override
    public void addAccount(Account account) {

    }

    @Override
    public Account updateAccount(Integer id, Account account) {
        return null;
    }

    @Override
    public boolean deleteAccount(Integer id) {
        return false;
    }
}
