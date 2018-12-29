package com.zentech.smashnexus.repository;

import com.zentech.smashnexus.model.Authority;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorityRepository extends MongoRepository<Authority, String> {

}
