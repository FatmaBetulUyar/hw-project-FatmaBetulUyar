package com.patika.paycore.Project.controller;

import com.patika.paycore.Project.model.entity.Transfer;
import com.patika.paycore.Project.model.dto.TransferDto;
import com.patika.paycore.Project.service.TransferService;
import lombok.RequiredArgsConstructor;
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
    public Transfer getTransfer(@PathVariable Integer id){
        return transferService.getTransfer(id);
    }

    @PostMapping(value = "/add")
    public void saveTransfer(@Valid @RequestBody TransferDto transfer){

        transferService.addTransfer(transfer);
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
