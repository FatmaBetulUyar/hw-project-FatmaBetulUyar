package com.patika.paycore.Project.controller;


import com.patika.paycore.Project.model.entity.Bank;
import com.patika.paycore.Project.service.BankService;
import lombok.RequiredArgsConstructor;
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
    public Bank getBank(@PathVariable Integer id){
        return bankService.getBank(id);
    }
    @PostMapping(value = "/add")
    public void saveBank(@Valid @RequestBody Bank bank){
        bankService.addBank(bank);
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
