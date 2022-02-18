package com.patika.paycore.Project.model.mapper;

import com.patika.paycore.Project.model.Bank;
import com.patika.paycore.Project.model.User;
import com.patika.paycore.Project.model.dto.UserDto;

public class UserMapper {
    public static UserDto toDto(User user){
        UserDto userDto=new UserDto();
        Bank bank=new Bank();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        userDto.setBankName(bank.getName());
        return userDto;
    }

    public static User toEntity(UserDto userDto){
        User user =new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        return user;
    }

}
