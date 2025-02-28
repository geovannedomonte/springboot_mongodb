package com.geovannedomonte.projetomongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovannedomonte.projetomongo.domain.Post;
import com.geovannedomonte.projetomongo.repository.PostRepository;
import com.geovannedomonte.projetomongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository reposi;
	
	
	public Post findById(String id) {
			Post user = reposi.findById(id).orElse(null);
			if (user == null) {
				throw new ObjectNotFoundException("Obejeto não encintrado");
			}
			return user;
	}
	
	public List<Post> findByTitle(String text) {
		return reposi.searchTitle(text);
	}
}
