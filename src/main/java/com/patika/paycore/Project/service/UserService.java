package com.patika.paycore.Project.service;

import com.patika.paycore.Project.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Integer id);

    void addUser(User user);

    User updateUser(Integer id, User user);

    boolean deleteUser(Integer id);
}
