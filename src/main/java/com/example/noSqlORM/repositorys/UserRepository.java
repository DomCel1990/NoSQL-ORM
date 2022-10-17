package com.example.noSqlORM.repositorys;

import com.example.noSqlORM.entitis.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
