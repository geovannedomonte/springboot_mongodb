package com.geovannedomonte.projetomongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovannedomonte.projetomongo.domain.User;
import com.geovannedomonte.projetomongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository reposi;
	
	public List<User> findAll(){
		return reposi.findAll();
	}

}
