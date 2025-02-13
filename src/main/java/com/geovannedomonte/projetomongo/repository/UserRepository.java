package com.geovannedomonte.projetomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.geovannedomonte.projetomongo.domain.User;


@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
