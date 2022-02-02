package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.User;
import com.patika.paycore.Project.repository.UserRepository;
import com.patika.paycore.Project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        Optional<User> byId=userRepository.findById(id);
        return byId.orElseThrow(()->new NotFoundException("User"));
    }
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
    @Override
    public User updateUser(Integer id, User user) {
        getUser(id);
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(Integer id) {
        userRepository.delete(getUser(id));
        return true;
    }
}
