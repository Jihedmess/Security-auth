package com.pfe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.dao.UserDao;
import com.pfe.model.DataBaseDTO;
import com.pfe.model.UserDTO;
import com.pfe.service.DataSourceService;
import com.pfe.service.JwtUserDetailsService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DataBaseController {
	@Autowired
	private DataSourceService dataSourceService;
	
	
	@RequestMapping(value = "/addDataBase", method = RequestMethod.POST)
	public ResponseEntity<?> saveDataBase(@RequestBody DataBaseDTO database) throws Exception {
		return ResponseEntity.ok(dataSourceService.save(database));
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/dataBases", method = RequestMethod.GET)
	public ResponseEntity<?> getUser() throws Exception {
		return ResponseEntity.ok(dataSourceService.getAll());
	}
	
	
	@RequestMapping(value = "/dataBase", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@RequestParam Integer id) throws Exception {
		return ResponseEntity.ok(dataSourceService.getUserById(id));
	}
	
	
	@RequestMapping(value = "/dataBaseDelete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@RequestParam Integer id) throws Exception {
		return ResponseEntity.ok(dataSourceService.delteUser(id));
	}
	
	@RequestMapping(value = "/updateDataBase", method = RequestMethod.PUT)
	public ResponseEntity<?> UpdateUser(@RequestBody DataBaseDTO database) throws Exception {
		return ResponseEntity.ok(dataSourceService.updateUser(database));
	}
	

	

}
