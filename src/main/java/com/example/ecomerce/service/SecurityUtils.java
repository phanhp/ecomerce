package com.example.ecomerce.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityUtils {

    public static List<String> getRolesOfUser() {
        List<String> roles = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                Collection<GrantedAuthority> authoritys = (Collection<GrantedAuthority>) userDetails.getAuthorities();
                if (!CollectionUtils.isEmpty(authoritys)) {
                    for (GrantedAuthority authority : authoritys) {
                        roles.add(authority.getAuthority());
                    }
                }
            }
        }
        return roles;
    }
}
