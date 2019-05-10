package com.neoxamhr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neoxamhr.entities.User;



@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	long countByMailAndPassword(String login,String pasword);
	User findByMailAndPassword(String login,String pasword);
	User findByMail(String id);
}
