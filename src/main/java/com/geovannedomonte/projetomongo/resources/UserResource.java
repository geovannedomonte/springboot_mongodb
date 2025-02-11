package com.geovannedomonte.projetomongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geovannedomonte.projetomongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Gomes", "maria@gmail.com");
		User jhow = new User("2", "Maria Gomes", "maria@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, jhow));
		return ResponseEntity.ok().body(list);
	}

}
