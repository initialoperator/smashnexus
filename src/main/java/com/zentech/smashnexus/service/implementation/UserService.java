package com.zentech.smashnexus.service.implementation;

import com.zentech.smashnexus.model.UserDetail;
import com.zentech.smashnexus.repository.UserDetailRepository;
import com.zentech.smashnexus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetail saveUser(UserDetail userDetail) {
        UserDetail ud = this.userDetailRepository.save(userDetail);//chrystian note: implementation too simple, will be removed in the future
        return ud;
    }

    @Override
    public UserDetail getUserWithId(Long userId) {
        return this.userDetailRepository.findById(userId).get();//chrystian note: implementation too simple, will be removed in the future
    }
}
