package com.patika.paycore.Project.repository;

import com.patika.paycore.Project.model.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient,Integer> {
}
