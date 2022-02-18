package com.patika.paycore.Project.repository;

import com.patika.paycore.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByUserName(String username);
    User findByUserName(String username);
    void deleteByUserName(String username);
}
