package com.zentech.smashnexus.service;

import com.zentech.smashnexus.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    User saveUser(User user);
    User getUserWithId(String userId);
    User loadUserByUsername(String s);
}
