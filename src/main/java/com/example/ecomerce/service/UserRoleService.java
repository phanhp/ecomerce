package com.example.ecomerce.service;

import com.example.ecomerce.entity.UserRoleEntity;
import com.example.ecomerce.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    public void save(UserRoleEntity userRole) {
        userRoleRepository.save(userRole);
    }

    public List<UserRoleEntity> findAll() {
        return (List<UserRoleEntity>) userRoleRepository.findAll();
    }
}
