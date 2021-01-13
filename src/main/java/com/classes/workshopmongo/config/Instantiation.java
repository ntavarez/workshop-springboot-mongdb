package com.classes.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.classes.workshopmongo.domain.User;
import com.classes.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();

		User maria = new User(null,"Maria Silva", "maria@gmail.com");
		User alex = new User(null,"Alex Santos", "alex@gmail.com");
		User roberto = new User(null,"Roberto Mendes", "roberto@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, roberto));
	}

}
