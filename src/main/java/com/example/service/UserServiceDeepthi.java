package com.example.service;

import com.example.entity.UserEntityDeepthi;
import com.example.repository.UserRepoDeepthi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDeepthi {
    @Autowired
    private UserRepoDeepthi userRepository;

    public UserEntityDeepthi addUserDeepthi(UserEntityDeepthi user) {
        return userRepository.save(user);
    }

    public UserEntityDeepthi getUserByIdDeepthi(int id) {
        return userRepository.findById(id).get();
    }
}
