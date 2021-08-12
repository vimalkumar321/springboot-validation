package com.vimal.demo.springbootvalidation.repository;


import com.vimal.demo.springbootvalidation.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

}
