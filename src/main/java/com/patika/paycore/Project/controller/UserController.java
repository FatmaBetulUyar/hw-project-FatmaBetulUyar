package com.patika.paycore.Project.controller;

import com.patika.paycore.Project.model.Account;
import com.patika.paycore.Project.model.User;
import com.patika.paycore.Project.model.dto.RegistirationDto;
import com.patika.paycore.Project.model.dto.UserDto;
import com.patika.paycore.Project.model.dto.UserLoginDto;
import com.patika.paycore.Project.model.mapper.UserMapper;
import com.patika.paycore.Project.service.BankService;
import com.patika.paycore.Project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;
    private final BankService bankService;

    @GetMapping
    public String welcome() {
        return "Welcome to Banking Service!";
    }

    @GetMapping(value = "/all")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PostMapping(value = "/add")
    public void saveUser(@Valid @RequestBody UserDto user){
            userService.addUser(user);
    }

    @PostMapping(value = "/signin")
    public String Login(@Valid @RequestBody UserLoginDto userLoginDto){
            return userService.signin(userLoginDto.getUserName(),userLoginDto.getPassword());
    }

    @PostMapping(value = "/signup")
    public String signup(@RequestBody @Valid RegistirationDto registirationDto){
        ModelMapper modelMapper=new ModelMapper();
        return userService.signup(modelMapper.map(registirationDto,User.class));
    }

    @PutMapping(value = "/update/{id}")
    public User updateUser(@PathVariable Integer id, @Valid @RequestBody User user) {
        return userService.updateUser(id,user);
    }

    @DeleteMapping(value = "/delete")
    public void deleteUser(@RequestParam String username) {
         userService.deleteUser(username);
    }

}
