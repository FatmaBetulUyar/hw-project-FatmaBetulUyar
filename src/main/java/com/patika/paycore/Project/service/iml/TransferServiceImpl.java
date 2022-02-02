package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.Transfer;
import com.patika.paycore.Project.repository.TransferRepository;
import com.patika.paycore.Project.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final TransferRepository transferRepository;
    @Override
    public List<Transfer> getAllTransfers() {
        return transferRepository.findAll();
    }

    @Override
    public Transfer getTransfer(Integer id) {
        Optional<Transfer> byId=transferRepository.findById(id);
        return byId.orElseThrow(()->new NotFoundException("Transfer"));
    }

    @Override
    public void addTransfer(Transfer transfer) {
         transferRepository.save(transfer);
    }

    @Override
    public Transfer updateTransfer(Integer id, Transfer transfer) {
        getTransfer(id);
        transfer.setId(id);
        return transferRepository.save(transfer);
    }

    @Override
    public boolean deleteTransfer(Integer id) {
        transferRepository.delete(getTransfer(id));
        return true;
    }
}
