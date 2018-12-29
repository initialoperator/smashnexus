package com.zentech.smashnexus.repository;

import com.zentech.smashnexus.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDetailRepository extends MongoRepository<User, String> {

    public User findByUsername(String username);
}
