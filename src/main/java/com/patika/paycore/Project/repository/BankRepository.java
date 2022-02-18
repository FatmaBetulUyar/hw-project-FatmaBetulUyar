package com.patika.paycore.Project.repository;

import com.patika.paycore.Project.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank,Integer> {

  //  Bank findBankByName(String bankName);
    Bank findByName(String bankName);
}
