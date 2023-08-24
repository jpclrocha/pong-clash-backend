package com.jopezin.pongclash.controllers;

import com.jopezin.pongclash.domain.user.User;
import com.jopezin.pongclash.dto.RegisterDTO;
import com.jopezin.pongclash.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody RegisterDTO registerObj){
        if(service.findByEmail(registerObj.email()) != null) throw new RuntimeException("Usuario ja existe");
        User user = new User(UUID.randomUUID(),
                             registerObj.firstname(),
                             registerObj.lastname(),
                             registerObj.email(),
                             registerObj.password());

        User obj = service.insert(user);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}