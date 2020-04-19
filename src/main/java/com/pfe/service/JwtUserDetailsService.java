package com.pfe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pfe.dao.UserDao;
import com.pfe.model.DAOUser;
import com.pfe.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		newUser.setEmail(user.getEmail());
		return userDao.save(newUser);
	}
	
	public List<DAOUser> getAll() {
		
		return (List<DAOUser>) userDao.findAll();
	}

	public Optional<DAOUser> getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	public StringBuffer delteUser(Integer id) {
		// TODO Auto-generated method stub
		userDao.deleteById(id);
		StringBuffer retBuf = new StringBuffer();
		retBuf.append("User data has been deleted successfully.");
		return retBuf;
	}


}