package com.geovannedomonte.projetomongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.geovannedomonte.projetomongo.domain.Post;
import com.geovannedomonte.projetomongo.domain.User;
import com.geovannedomonte.projetomongo.dto.AuthorDTO;
import com.geovannedomonte.projetomongo.dto.CommentDTO;
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
		
		userRepository.saveAll(Arrays.asList(maria, alex, geo));
		
		Post post1 = new Post(null, sdf.parse("01/01/2025"), "Feliz Ano Novo!!!!!", "Muita saude e paz para esse ano.", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("01/01/2025"), "Primeira postagem do ano!!!!!", "Muitas Felicidades minha gente.", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Feliz ano novo minha amiga", sdf.parse("02/01/2025"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("FAZ o L", sdf.parse("02/01/2025"), new AuthorDTO(geo));
		CommentDTO c3 = new CommentDTO("Viciada em internet", sdf.parse("03/01/2025"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

	

}
