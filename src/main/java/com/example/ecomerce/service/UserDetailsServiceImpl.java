package com.example.ecomerce.service;

import com.example.ecomerce.entity.UserEntity;
import com.example.ecomerce.entity.UserRoleEntity;
import com.example.ecomerce.enums.UserStatus;
import com.example.ecomerce.repository.UserRepository;
import com.example.ecomerce.repository.UserRoleRepository;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmailLikeAndStatusLike(email, UserStatus.ACTIVE);
        if (user == null){
            throw new UsernameNotFoundException("Email "+email+" can not be found or inactive");
        }
        return new CustomUserDetails(user);
    }

    public List<UserEntity> findAll() {
        return (List<UserEntity>) userRepository.findAll();
    }
}
