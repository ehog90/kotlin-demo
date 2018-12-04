package com.bence.ujj.kotlindemo.database;


import com.bence.ujj.kotlindemo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
