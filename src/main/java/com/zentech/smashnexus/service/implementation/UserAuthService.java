package com.zentech.smashnexus.service.implementation;

import com.zentech.smashnexus.model.User;
import com.zentech.smashnexus.repository.UserAuthRepository;
import com.zentech.smashnexus.service.IUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements IUserAuthService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User saveUser(User user) {
        String password = user.getPassword();
        String passwordHased = this.encoder.encode(password);
        user.setPassword(passwordHased);
        User ud = this.userAuthRepository.save(user);
        return ud;
    }

    @Override
    public User getUserWithId(String userId) {
        return this.userAuthRepository.findById(userId).get();
    }

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        return this.userAuthRepository.findByUsername(s);
    }
}
