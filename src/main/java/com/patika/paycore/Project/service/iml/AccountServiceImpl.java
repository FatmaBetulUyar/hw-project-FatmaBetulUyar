package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.entity.Account;
import com.patika.paycore.Project.repository.AccountRepository;
import com.patika.paycore.Project.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccount(Integer id) {
        Optional<Account> byId=accountRepository.findById(id);
        return byId.orElseThrow(()->new NotFoundException("Account"));
    }

    @Override
    public Account addAccount(Account account) {

       return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Integer id, Account account) {
        getAccount(id);
        account.setId(id);
        return accountRepository.save(account);
    }

    @Override
    public boolean deleteAccount(Integer id) {
        accountRepository.delete(getAccount(id));
        return true;
    }
}
