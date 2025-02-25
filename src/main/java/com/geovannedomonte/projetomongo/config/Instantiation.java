package com.geovannedomonte.projetomongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.geovannedomonte.projetomongo.domain.Post;
import com.geovannedomonte.projetomongo.domain.User;
import com.geovannedomonte.projetomongo.repository.PostRepository;
import com.geovannedomonte.projetomongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria GG Silva", "maria@gmail.com");
		User alex = new User(null, "Alex Ta DLuto", "dluto@gmail.com");
		User geo = new User(null, "Geo Super Monte", "gg@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("01/01/2025"), "Feliz Ano Novo!", "Muita saude e paz para esse ano.", maria);
		Post post2 = new Post(null, sdf.parse("01/01/2025"), "Primeira postagem do ano!", "Muitas Felicidades minha gente.", maria);
		
		
		userRepository.saveAll(Arrays.asList(maria, alex, geo));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

	

}
