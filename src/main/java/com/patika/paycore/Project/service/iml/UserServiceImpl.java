package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.model.User;
import com.patika.paycore.Project.repository.UserRepository;
import com.patika.paycore.Project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);

    }

    @Override
    public User updateUser(Integer id, User user) {
        return null;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return false;
    }
}
