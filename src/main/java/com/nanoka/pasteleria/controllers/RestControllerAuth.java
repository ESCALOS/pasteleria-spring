package com.nanoka.pasteleria.controllers;

import java.security.Principal;
import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanoka.pasteleria.dtos.DtoAuthResponse;
import com.nanoka.pasteleria.dtos.DtoCurrentUser;
import com.nanoka.pasteleria.dtos.DtoLogin;
import com.nanoka.pasteleria.dtos.DtoRegister;
import com.nanoka.pasteleria.models.Role;
import com.nanoka.pasteleria.models.UserEntity;
import com.nanoka.pasteleria.repositories.IRoleRepository;
import com.nanoka.pasteleria.repositories.IUserRepository;
import com.nanoka.pasteleria.security.JwtGenerador;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@AllArgsConstructor
@RequestMapping("/api/auth/")
public class RestControllerAuth {
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private IRoleRepository roleRepository;
    private IUserRepository userRepository;
    private JwtGenerador jwtGenerador;
    
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody DtoRegister dtoRegister) {
        if(userRepository.existsByUsername(dtoRegister.getUsername())){
            return new ResponseEntity<>("El usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        UserEntity user = new UserEntity();
        user.setUsername(dtoRegister.getUsername());
        user.setPassword(passwordEncoder.encode(dtoRegister.getPassword()));
		user.setName(dtoRegister.getName());
        Role role = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(role));
        userRepository.save(user);
        return new ResponseEntity<String>("Registro de usuario exitoso", HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<DtoAuthResponse> login(@RequestBody DtoLogin dtoLogin) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dtoLogin.getUsername(), dtoLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerador.generateToken(authentication);
        return new ResponseEntity<DtoAuthResponse>(new DtoAuthResponse(token), HttpStatus.OK);
    }

    @GetMapping("current-user")
    public ResponseEntity<DtoCurrentUser> obtenerUsuarioActual(Principal principal) {
        UserEntity user = userRepository.findByUsername(principal.getName()).get();
        return new ResponseEntity<DtoCurrentUser>(new DtoCurrentUser(user.getUsername(), user.getName(), user.getRoles()), HttpStatus.OK);
    }

}
