package com.patika.paycore.Project.controller;

import com.patika.paycore.Project.model.Transfer;
import com.patika.paycore.Project.service.TransactionService;
import com.patika.paycore.Project.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
