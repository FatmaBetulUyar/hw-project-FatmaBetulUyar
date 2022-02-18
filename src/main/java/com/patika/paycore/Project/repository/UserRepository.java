package com.patika.paycore.Project.repository;

import com.patika.paycore.Project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Customer,Integer> {
    boolean existsByUserName(String username);
    Customer findByUserName(String username);
    void deleteByUserName(String username);
}
