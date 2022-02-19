package com.patika.paycore.Project.controller;

import com.patika.paycore.Project.exception.InsufficientBalanceException;
import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.dto.TransactionDto;
import com.patika.paycore.Project.model.entity.Transfer;
import com.patika.paycore.Project.model.dto.TransferDto;
import com.patika.paycore.Project.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/transfer")
public class TransferController {

    private final TransferService transferService;

    @GetMapping(value = "all")
    private List<Transfer> getAllTransfers(){
        return transferService.getAllTransfers();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTransfer(@PathVariable Integer id){
        ResponseEntity<?> response;
        try {
            transferService.getTransfer(id);
            response= new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException exception){
            response =new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> saveTransfer(@Valid @RequestBody TransferDto transfer){
        ResponseEntity<?> response;
        try {
            transferService.addTransfer(transfer);
            response= new ResponseEntity<>(HttpStatus.OK);
        } catch (InsufficientBalanceException exception) {
            response =new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return response;
    }



    @PutMapping(value = "/update/{id}")
    public Transfer updateTransfer(@PathVariable Integer id, @Valid @RequestBody Transfer transfer) {
        return transferService.updateTransfer(id,transfer);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteTransfer(@RequestParam Integer id) {
        return transferService.deleteTransfer(id);
    }
}
