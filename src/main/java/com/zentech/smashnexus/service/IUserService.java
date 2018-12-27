package com.zentech.smashnexus.service;

import com.zentech.smashnexus.model.UserDetail;

public interface IUserService {

    UserDetail saveUser(UserDetail userDetail);
    UserDetail getUserWithId(Long userId);
}
