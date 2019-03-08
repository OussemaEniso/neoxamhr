package com.neoxamhr.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neoxamhr.entities.User;



@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	long countByLoginAndPassword(String login,String pasword);
	User findByLoginAndPassword(String login,String pasword);
}
