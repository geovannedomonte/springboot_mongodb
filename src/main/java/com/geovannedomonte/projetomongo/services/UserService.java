package com.geovannedomonte.projetomongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovannedomonte.projetomongo.domain.User;
import com.geovannedomonte.projetomongo.dto.UserDTO;
import com.geovannedomonte.projetomongo.repository.UserRepository;
import com.geovannedomonte.projetomongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository reposi;
	
	public List<User> findAll(){
		return reposi.findAll();
	}
	
	public User findById(String id) {
			User user = reposi.findById(id).orElse(null);
			if (user == null) {
				throw new ObjectNotFoundException("Obejeto não encintrado");
			}
			return user;
	}
	
	public User insert(User obj) {
		return reposi.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
