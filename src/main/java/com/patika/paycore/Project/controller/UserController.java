package com.patika.paycore.Project.controller;


import com.patika.paycore.Project.model.dto.RegistirationDto;
import com.patika.paycore.Project.model.dto.UserLoginDto;
import com.patika.paycore.Project.model.entity.User;
import com.patika.paycore.Project.service.iml.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public String login(@Valid @RequestBody UserLoginDto userLoginDTO) {
        return userService.signin(userLoginDTO.getUsername(), userLoginDTO.getPassword());
    }

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid RegistirationDto user) {
        ModelMapper modelMapper = new ModelMapper();
        return userService.signup(modelMapper.map(user, User.class));
    }

    @DeleteMapping(value = "/{username}")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return username;
    }




}
