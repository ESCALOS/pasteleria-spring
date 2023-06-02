package com.nanoka.pasteleria;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nanoka.pasteleria.models.Role;
import com.nanoka.pasteleria.models.UserEntity;
import com.nanoka.pasteleria.repositories.IRoleRepository;
import com.nanoka.pasteleria.repositories.IUserRepository;

@SpringBootApplication
public class PasteleriaApplication implements CommandLineRunner{

	@Autowired
	private IRoleRepository roleRepository;
	
	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(PasteleriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(!roleRepository.existsByName("ADMIN")){
			Role role = new Role();
			role.setName("ADMIN");
			roleRepository.save(role);
		}

		if(!userRepository.existsByUsername("ADMIN")){
			UserEntity user = new UserEntity();
			user.setName("ADMIN");
			user.setUsername("ADMIN");
			user.setPassword(passwordEncoder.encode("admin"));
			Role rol = roleRepository.findByName("ADMIN").get();
			user.setRoles(Collections.singletonList(rol));
			userRepository.save(user);
		}
		
	}

}
