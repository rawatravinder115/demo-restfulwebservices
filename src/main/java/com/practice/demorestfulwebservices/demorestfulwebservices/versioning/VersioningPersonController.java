package com.practice.demorestfulwebservices.demorestfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public Person1 getFirstVersioningPerson(){
        return new Person1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public Person2 getSecondVersioningPerson(){
        return new Person2(new Name("Bob", "Charlie"));
    }
}

