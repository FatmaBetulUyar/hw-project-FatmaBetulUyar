package com.patika.paycore.Project.model.mapper;

import com.patika.paycore.Project.model.Bank;
import com.patika.paycore.Project.model.Customer;
import com.patika.paycore.Project.model.dto.CustomerDto;

public class UserMapper {
    public static CustomerDto toDto(Customer user){
        CustomerDto customerDto =new CustomerDto();
        Bank bank=new Bank();
        customerDto.setFirstName(user.getFirstName());
        customerDto.setLastName(user.getLastName());
        customerDto.setEmail(user.getEmail());
        customerDto.setPhone(user.getPhone());
        customerDto.setBankName(bank.getName());
        return customerDto;
    }

    public static Customer toEntity(CustomerDto customerDto){
        Customer user =new Customer();
        user.setFirstName(customerDto.getFirstName());
        user.setLastName(customerDto.getLastName());
        user.setEmail(customerDto.getEmail());
        user.setPhone(customerDto.getPhone());
        return user;
    }

}
