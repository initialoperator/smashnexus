package com.zentech.smashnexus.service.implementation;

import com.zentech.smashnexus.model.User;
import com.zentech.smashnexus.repository.UserDetailRepository;
import com.zentech.smashnexus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User saveUser(User user) {
        String password = user.getPassword();
        String passwordHased = this.encoder.encode(password);
        user.setPassword(passwordHased);
        User ud = this.userDetailRepository.save(user);
        return ud;
    }

    @Override
    public User getUserWithId(String userId) {
        return this.userDetailRepository.findById(userId).get();
    }

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        return this.userDetailRepository.findByUsername(s);
    }
}
