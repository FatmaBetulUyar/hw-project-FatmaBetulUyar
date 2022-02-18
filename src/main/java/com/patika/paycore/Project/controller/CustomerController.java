package com.patika.paycore.Project.controller;

import com.patika.paycore.Project.model.Customer;
import com.patika.paycore.Project.model.dto.CustomerDto;
import com.patika.paycore.Project.service.BankService;
import com.patika.paycore.Project.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final BankService bankService;

    @GetMapping
    public String welcome() {
        return "Welcome to Banking Service!";
    }

    @GetMapping(value = "/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable Integer id){
        return customerService.getCustomer(id);
    }

    @PostMapping(value = "/add")
    public void saveCustomer(@Valid @RequestBody CustomerDto customer){
            customerService.addCustomer(customer);
    }


    @PutMapping(value = "/update/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer customer) {
        return customerService.updateCustomer(id,customer);
    }

    @DeleteMapping(value = "/delete")
    public void deleteUser(@RequestParam String username) {
         customerService.deleteCustomer(username);
    }

}
