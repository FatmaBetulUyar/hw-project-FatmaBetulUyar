package com.patika.paycore.Project.controller;


import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.entity.Account;
import com.patika.paycore.Project.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAccount(@PathVariable Integer id){
        ResponseEntity<?> response;
        try {
            accountService.getAccount(id);
            response= new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException exception){
            response =new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> saveAccount(@Valid @RequestBody Account account){
        ResponseEntity<?> response;
        try {
            accountService.addAccount(account);
            response= new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            response =new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return response;
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
