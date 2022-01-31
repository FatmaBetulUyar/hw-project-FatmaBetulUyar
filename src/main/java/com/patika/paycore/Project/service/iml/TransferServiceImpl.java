package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.model.Transfer;
import com.patika.paycore.Project.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    @Override
    public List<Transfer> getAllTransfers() {
        return null;
    }

    @Override
    public Transfer getTransfer(Integer id) {
        return null;
    }

    @Override
    public void addTransfer(Transfer transfer) {

    }

    @Override
    public Transfer updateTransfer(Integer id, Transfer transfer) {
        return null;
    }

    @Override
    public boolean deleteTransfer(Integer id) {
        return false;
    }
}
