package com.patika.paycore.Project.controller;


import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.entity.Bank;
import com.patika.paycore.Project.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/bank")
public class BankController {

    private final BankService bankService;

    @GetMapping(value = "/all")
    public List<Bank> getAll(){
        return bankService.getAllBanks();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?>  getBank(@PathVariable Integer id){
        ResponseEntity<?> response;
        try {
            bankService.getBank(id);
            response= new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException exception){
            response =new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> saveBank(@Valid @RequestBody Bank bank){
        ResponseEntity<?> response;
        try {
            bankService.addBank(bank);
            response= new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception exception){
            response =new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PutMapping(value = "/update/{id}")
    public Bank updateBank(@PathVariable Integer id, @Valid @RequestBody Bank bank) {
        return bankService.updateBank(id,bank);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteBank(@RequestParam Integer id) {
        return bankService.deleteBank(id);
    }
}
