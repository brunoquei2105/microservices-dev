package com.devsuperior.hr.user.controller;

import com.devsuperior.hr.user.model.User;
import com.devsuperior.hr.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){

        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/email/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
       Optional<User> userEmail = userRepository.findByEmail(email);
        return userEmail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
