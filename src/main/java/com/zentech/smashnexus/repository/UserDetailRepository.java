package com.zentech.smashnexus.repository;

import com.zentech.smashnexus.model.UserDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDetailRepository extends MongoRepository<UserDetail, Long> {

    public UserDetail findByUsername(String username);
}
