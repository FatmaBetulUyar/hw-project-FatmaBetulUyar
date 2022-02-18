package com.patika.paycore.Project.controller;


import com.patika.paycore.Project.model.Bank;
import com.patika.paycore.Project.model.Recipient;
import com.patika.paycore.Project.model.Transaction;
import com.patika.paycore.Project.service.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/recipient")
public class RecipientController {

    private final RecipientService recipientService;

    @GetMapping(value = "/all")
    public List<Recipient> getAll(){
        return recipientService.getAllRecipients();
    }

    @GetMapping(value = "/{id}")
    public Recipient getRecipient(@PathVariable Integer id){
        return recipientService.getRecipient(id);
    }
    @PostMapping(value = "/add")
    public Recipient saveRecipient(@Valid @RequestBody Recipient recipient){
      return recipientService.addRecipient(recipient);
    }

    @PutMapping(value = "/update/{id}")
    public Recipient updateRecipient(@PathVariable Integer id, @Valid @RequestBody Recipient recipient) {
        return recipientService.updateRecipient(id,recipient);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteRecipient(@RequestParam Integer id) {
        return recipientService.deleteRecipient(id);
    }
}
