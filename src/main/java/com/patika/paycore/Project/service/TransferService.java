package com.patika.paycore.Project.service;

import com.patika.paycore.Project.model.Transfer;
import com.patika.paycore.Project.model.User;

import java.util.List;

public interface TransferService {
    List<Transfer> getAllTransfers();

    Transfer getTransfer(Integer id);

    void addTransfer(Transfer transfer);

    Transfer updateTransfer(Integer id, Transfer transfer);

    boolean deleteTransfer(Integer id);
}
