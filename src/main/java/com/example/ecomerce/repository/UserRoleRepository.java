package com.example.ecomerce.repository;

import com.example.ecomerce.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {

    Set<UserRoleEntity> findByUsers_Email(String email);
}
