package com.geovannedomonte.projetomongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.geovannedomonte.projetomongo.domain.User;
import com.geovannedomonte.projetomongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria GG Silva", "maria@gmail.com");
		User alex = new User(null, "Alex Ta DLuto", "dluto@gmail.com");
		User geo = new User(null, "Geo Super Monte", "gg@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, geo));
	}

	

}
