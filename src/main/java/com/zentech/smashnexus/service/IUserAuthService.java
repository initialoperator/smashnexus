package com.zentech.smashnexus.service;

import com.zentech.smashnexus.Exception.UserRegistrationException;
import com.zentech.smashnexus.model.User;
import com.zentech.smashnexus.viewobject.UserRegistratinVO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserAuthService extends UserDetailsService {

    User registerUser(UserRegistratinVO user) throws UserRegistrationException;
    User saveUser(User user);
    User getUserWithId(String userId);
    User loadUserByUsername(String s);


}
