package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.Account;
import com.patika.paycore.Project.model.Bank;
import com.patika.paycore.Project.model.Customer;
import com.patika.paycore.Project.model.dto.CustomerDto;
import com.patika.paycore.Project.model.mapper.UserMapper;
import com.patika.paycore.Project.repository.BankRepository;
import com.patika.paycore.Project.repository.UserRepository;
import com.patika.paycore.Project.service.AccountService;
import com.patika.paycore.Project.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository;
    private final UserRepository userRepository;
    private final AccountService accountService;
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

    @Override
    public void addNewAccount(CustomerDto customerDto) {
        Customer entity = new Customer();
        Account account = new Account();
        entity = UserMapper.toEntity(customerDto);
        Bank bank = bankRepository.findByName(customerDto.getBankName());

        // account.setUser(entity);
        UUID uuid = UUID.randomUUID();
        account.setAccountNumber(uuid.toString());
        account.setBank(bank);
        account.setBalance(0.0F);
        account = accountService.addAccount(account);
        entity.setAccount(account);
        entity = userRepository.save(entity);




    }
}
