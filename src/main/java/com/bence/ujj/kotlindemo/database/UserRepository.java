package com.bence.ujj.kotlindemo.database;


import com.bence.ujj.kotlindemo.models.StoredUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<StoredUser, String> {
    Optional<StoredUser> findByUserId(String userId);
}
