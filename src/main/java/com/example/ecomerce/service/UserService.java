package com.example.ecomerce.service;

import com.example.ecomerce.entity.UserEntity;
import com.example.ecomerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void save(UserEntity user) {
        userRepository.save(user);
    }

    public List<UserEntity> findAll() {
        return (List<UserEntity>) userRepository.findAll();
    }

    public Optional<UserEntity> findById(int id) {
        return userRepository.findById(id);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public List<UserEntity> searchByName(String keyword) {
        return userRepository.searchByName(keyword);
    }
}
