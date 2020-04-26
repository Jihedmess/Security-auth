package com.pfe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.DataBaseDAO;
import com.pfe.dao.UserDao;
import com.pfe.model.DAODataBase;
import com.pfe.model.DAOUser;
import com.pfe.model.DataBaseDTO;
import com.pfe.model.UserDTO;

@Service
public class DataSourceService {
	@Autowired
	private DataBaseDAO dataBaseDAO;
	
	public DAODataBase save(DataBaseDTO database) {
		DAODataBase newDataBase = new DAODataBase();
		newDataBase.setUrl(database.getUrl());
		newDataBase.setUser(database.getUser());
		newDataBase.setPassword(database.getPassword());
		
		return dataBaseDAO.save(newDataBase);
	}
	
	
public List<DAODataBase> getAll() {
		
		return (List<DAODataBase>) dataBaseDAO.findAll();
	}


public Optional<DAODataBase> getUserById(Integer id) {
	// TODO Auto-generated method stub
	return dataBaseDAO.findById(id);
}

public StringBuffer delteUser(Integer id) {
	// TODO Auto-generated method stub
	dataBaseDAO.deleteById(id);
	StringBuffer retBuf = new StringBuffer();
	retBuf.append("User data has been deleted successfully.");
	return retBuf;
}


public DAODataBase updateUser(DataBaseDTO database) {
	Optional<DAODataBase> dataBase = dataBaseDAO.findById(database.id);
	
	if(dataBase.isPresent()) 
    {
		DAODataBase newEntity = dataBase.get();
        newEntity.setUrl(database.getUrl());
        newEntity.setPassword(database.getPassword());
        newEntity.setUser(database.getUser());
        newEntity = dataBaseDAO.save(newEntity);
        return newEntity;
    }
	return null;
}


}
