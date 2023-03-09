package com.practice.demorestfulwebservices.demorestfulwebservices.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource (UserDaoService service){
        this.service = service;
    }


    @GetMapping("/users")
    public List<User> retrienveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrienveUsersById(@PathVariable("id") int id){
        return service.findOne(id);
    }

}