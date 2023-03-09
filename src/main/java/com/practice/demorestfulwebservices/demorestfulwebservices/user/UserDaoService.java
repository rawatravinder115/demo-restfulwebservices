package com.practice.demorestfulwebservices.demorestfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    // JPA/HIBERNATE > Database
    // UserDaoService > Static List

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"ravi", LocalDate.now().minusYears(20)));
        users.add(new User(2,"ankit", LocalDate.now().minusYears(30)));
        users.add(new User(3,"kundan", LocalDate.now().minusYears(25)));
    }

    public  List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
       return users.stream().filter(predicate).findFirst().get();
    }
}
