package com.patika.paycore.Project.controller;

import com.patika.paycore.Project.model.User;
import com.patika.paycore.Project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String welcome() {
        return "Welcome to Banking Service!";
    }

    @GetMapping(value = "/all")
    public List<User> getAll(){
        return userService.getAllUsers();
    }


}
