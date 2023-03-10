package com.practice.demorestfulwebservices.demorestfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource (UserDaoService service){
        this.service = service;
    }


    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUsersById(@PathVariable("id") int id){
        User user = service.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id :"+ id);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsersById(@PathVariable int id){
         service.deleteById(id);
    }

    @PostMapping("/users")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
//      /users/4 => /users /{id}, user.getId().
//        this is code to generate the location which is api to get the new posted data.
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedUser.getId())
                        .toUri();
        return ResponseEntity.created(location).build();
    }

}
