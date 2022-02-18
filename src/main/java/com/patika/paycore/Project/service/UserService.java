package com.patika.paycore.Project.service;

import com.patika.paycore.Project.model.User;
import com.patika.paycore.Project.model.dto.UserDto;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Integer id);

    void addUser(UserDto user);

    User updateUser(Integer id, User user);

    void deleteUser(String username);

    public String signin(String username,String password);

    public String signup(User user);
}
