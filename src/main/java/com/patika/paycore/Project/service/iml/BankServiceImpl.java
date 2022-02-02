package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.Bank;
import com.patika.paycore.Project.repository.BankRepository;
import com.patika.paycore.Project.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository;
    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public Bank getBank(Integer id) {
        Optional<Bank> byId=bankRepository.findById(id);
        return byId.orElseThrow(()->new NotFoundException("Bank"));
    }

    @Override
    public void addBank(Bank bank) {
        bankRepository.save(bank);
    }

    @Override
    public Bank updateBank(Integer id, Bank bank) {
        getBank(id);
        bank.setId(id);
        return bankRepository.save(bank);
    }

    @Override
    public boolean deleteBank(Integer id) {
        bankRepository.delete(getBank(id));
        return true;
    }
}
