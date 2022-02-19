package com.patika.paycore.Project.controller;

import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.entity.Customer;
import com.patika.paycore.Project.model.dto.CustomerDto;
import com.patika.paycore.Project.model.entity.Recipient;
import com.patika.paycore.Project.service.BankService;
import com.patika.paycore.Project.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/customer")
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
    public ResponseEntity<?> getCustomer(@PathVariable Integer id){
        ResponseEntity<?> response;
        try {
            customerService.getCustomer(id);
            response= new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException exception){
            response =new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerDto customer){
        ResponseEntity<?> response;
        try {
            customerService.addCustomer(customer);
            response= new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            response =new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return response;

    }

    @PutMapping(value = "/update/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer customer) {
        return customerService.updateCustomer(id,customer);
    }

    @DeleteMapping(value = "/delete")
    public void deleteUser(@RequestParam Integer id) {
         customerService.deleteCustomer(id);
    }

}
