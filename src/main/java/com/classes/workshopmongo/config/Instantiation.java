package com.classes.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.classes.workshopmongo.domain.Post;
import com.classes.workshopmongo.domain.User;
import com.classes.workshopmongo.repository.PostRepository;
import com.classes.workshopmongo.repository.UserRepository;

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

		User maria = new User(null,"Maria Silva", "maria@gmail.com");
		User alex = new User(null,"Alex Santos", "alex@gmail.com");
		User roberto = new User(null,"Roberto Mendes", "roberto@gmail.com");
		
		Post post1 = new Post(null,sdf.parse("21/08/2018"),"Partiu, viagem!", "Vou viajar pra São Paulo, abraços.", maria);
		Post post2 = new Post(null,sdf.parse("23/08/2018"),"Bom dia", "Hoje eu acordei feliz!", maria);

		
		userRepository.saveAll(Arrays.asList(maria, alex, roberto));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
