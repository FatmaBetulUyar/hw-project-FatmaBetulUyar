package com.patika.paycore.Project.service;

import com.patika.paycore.Project.model.Customer;
import com.patika.paycore.Project.model.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomer(Integer id);

    void addCustomer(CustomerDto user);

    Customer updateCustomer(Integer id, Customer user);

    void deleteCustomer(String username);

}
