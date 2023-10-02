package com.template.appbackend.controller;

import com.template.appbackend.model.User;
import com.template.appbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
// For simplicity of this sample, allow all origins. Real applications should configure CORS for their use case.
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public @ResponseBody Optional<User> getUser(@AuthenticationPrincipal Jwt jwt) {

        String email = (String) jwt.getClaims().get("email");
        String name = (String) jwt.getClaims().get("name");
        String picture = (String) jwt.getClaims().get("picture");

        boolean exists = userRepository.existsById(email);

        if(!exists) {
            userRepository.save(new User(email, name, picture));
        }

        return userRepository.findById(email);
    }
}
