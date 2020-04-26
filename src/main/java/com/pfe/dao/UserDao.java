package com.pfe.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfe.model.DAODataBase;
import com.pfe.model.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	@Query("SELECT u FROM user u WHERE u.username = ?1")
	DAOUser findByUsername(String username);
	
	@Query("SELECT u FROM user u WHERE u.email = ?1")
	DAOUser findByEmail(String username);
	
	
	
	
}