package com.patika.paycore.Project.controller;


import com.patika.paycore.Project.exception.InsufficientBalanceException;
import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.dto.TransferDto;
import com.patika.paycore.Project.model.entity.Recipient;
import com.patika.paycore.Project.service.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getRecipient(@PathVariable Integer id){

        ResponseEntity<?> response;
        try {
            recipientService.getRecipient(id);
            response= new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException exception){
            response =new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @PostMapping(value = "/add")
    public ResponseEntity<?> saveRecipient(@Valid @RequestBody Recipient recipient){
        ResponseEntity<?> response;
        try {
            recipientService.addRecipient(recipient);
            response= new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            response =new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return response;
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
