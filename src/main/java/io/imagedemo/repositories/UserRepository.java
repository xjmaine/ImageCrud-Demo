package io.imagedemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.imagedemo.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
