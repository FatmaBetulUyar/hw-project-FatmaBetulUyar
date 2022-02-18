package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.CustomJwtException;
import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.Account;
import com.patika.paycore.Project.model.Role;
import com.patika.paycore.Project.model.User;
import com.patika.paycore.Project.model.dto.UserDto;
import com.patika.paycore.Project.model.mapper.UserMapper;
import com.patika.paycore.Project.repository.RoleRepository;
import com.patika.paycore.Project.repository.UserRepository;
import com.patika.paycore.Project.security.JwtTokenProvider;
import com.patika.paycore.Project.service.BankService;
import com.patika.paycore.Project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
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
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        Optional<User> byId=userRepository.findById(id);
        return byId.orElseThrow(()->new NotFoundException("User"));
    }

    public String signin(String username,String password){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
            return jwtTokenProvider.createToken(username,userRepository.findByUserName(username).getRoles());
        }catch (AuthenticationException e){
            throw new CustomJwtException("Invalid username/password supplied", HttpStatus.BAD_REQUEST);
        }
    }

    public String signup(User user) {
        if (!userRepository.existsByUserName(user.getUserName())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Collections.singletonList(roleRepository.getById(2)));
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getUserName(), user.getRoles());
        } else {
            throw new CustomJwtException("Username is already in use", HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public void addUser(UserDto user) {
        bankService.addNewAccount(user);
    }
    @Override
    public User updateUser(Integer id, User user) {
        getUser(id);
        user.setId(id);
        return userRepository.save(user);
    }
    public void deleteUser(String username) {
        if (!userRepository.existsByUserName(username)) {
            userRepository.deleteByUserName(username);
        } else {
            throw new CustomJwtException("Username is not found", HttpStatus.NOT_FOUND);
        }
    }
}
