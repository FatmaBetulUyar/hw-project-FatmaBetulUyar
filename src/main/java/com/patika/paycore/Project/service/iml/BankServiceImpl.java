package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.model.Bank;
import com.patika.paycore.Project.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {
    @Override
    public List<Bank> getAllBanks() {
        return null;
    }

    @Override
    public Bank getBank(Integer id) {
        return null;
    }

    @Override
    public void addBank(Bank bank) {

    }

    @Override
    public Bank updateBank(Integer id, Bank bank) {
        return null;
    }

    @Override
    public boolean deleteBank(Integer id) {
        return false;
    }
}
