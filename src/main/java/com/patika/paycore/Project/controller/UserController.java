package com.patika.paycore.Project.controller;

import com.patika.paycore.Project.model.User;
import com.patika.paycore.Project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(value = "/{id]")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }
    @PostMapping(value = "/add")
        public void saveUser(@Valid @RequestBody User user){
            userService.addUser(user);
        }

    @PutMapping(value = "/update/{id}")
    public User updateAirport(@PathVariable Integer id, @Valid @RequestBody User user) {
        return userService.updateUser(id,user);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteAirport(@RequestParam Integer id) {
        return userService.deleteUser(id);
    }

}
