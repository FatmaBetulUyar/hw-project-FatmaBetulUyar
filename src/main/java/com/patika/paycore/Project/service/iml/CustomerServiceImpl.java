package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.CustomJwtException;
import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.entity.Customer;
import com.patika.paycore.Project.model.dto.CustomerDto;
import com.patika.paycore.Project.repository.RoleRepository;
import com.patika.paycore.Project.repository.CustomerRepository;
import com.patika.paycore.Project.security.JwtTokenProvider;
import com.patika.paycore.Project.service.BankService;
import com.patika.paycore.Project.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final RoleRepository roleRepository;
    private final CustomerRepository customerRepository;
    private final BankService bankService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

//    @PostConstruct
//    private void PostConstruct(){
//        User admin=new User();
//        admin.setUserName("admin_bet");
//        admin.setPassword("12345bet");
//        admin.setRoles(Collections.singletonList(Role.ROLE_ADMİN));
//        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
//        userRepository.save(admin);
//    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Integer id) {
        Optional<Customer> byId= customerRepository.findById(id);
        return byId.orElseThrow(()->new NotFoundException("User"));
    }


    @Override
    public void addCustomer(CustomerDto user) {
        bankService.addNewAccount(user);
    }
    @Override
    public Customer updateCustomer(Integer id, Customer user) {
        getCustomer(id);
        user.setId(id);
        return customerRepository.save(user);
    }
    public void deleteCustomer(Integer id) {
       customerRepository.delete(getCustomer(id));
    }
}
