package com.pfe.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfe.model.DAODataBase;
import com.pfe.model.DAOUser;

@Repository
public interface DataBaseDAO extends CrudRepository<DAODataBase, Integer> {
	

}
