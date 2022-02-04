package com.patika.paycore.Project.controller;


import com.patika.paycore.Project.model.Account;
import com.patika.paycore.Project.model.Bank;
import com.patika.paycore.Project.model.User;
import com.patika.paycore.Project.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping(value = "/all")
    public List<Account> getAll(){
        return accountService.getAllAccounts();
    }

    @GetMapping(value = "/{id]")
    public Account getAccount(@PathVariable Integer id){
        return accountService.getAccount(id);
    }
    @PostMapping(value = "/add")
    public void saveAccount(@Valid @RequestBody Account account){
        accountService.addAccount(account);
    }

    @PutMapping(value = "/update/{id}")
    public Account updateBank(@PathVariable Integer id, @Valid @RequestBody Account account) {
        return accountService.updateAccount(id,account);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteBank(@RequestParam Integer id) {
        return accountService.deleteAccount(id);
    }
}
