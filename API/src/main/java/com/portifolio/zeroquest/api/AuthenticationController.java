package com.portifolio.zeroquest.api;

import com.portifolio.zeroquest.domain.dtos.AuthenticationDTO;
import com.portifolio.zeroquest.domain.dtos.LoginResponseDTO;
import com.portifolio.zeroquest.domain.dtos.RegisterDTO;
import com.portifolio.zeroquest.domain.entities.User;
import com.portifolio.zeroquest.domain.repositories.UserRepository;
import com.portifolio.zeroquest.domain.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private UserRepository repository;

    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    public AuthenticationController(UserRepository repository, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody User data){

        if (this.repository.findByEmail(data.getEmail()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());

        User newUser = new User(data.getEmail(), encryptedPassword, data.getRoles());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
