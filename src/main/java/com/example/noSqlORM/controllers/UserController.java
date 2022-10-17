package com.example.noSqlORM.controllers;

import com.example.noSqlORM.entitis.User;
import com.example.noSqlORM.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUSer() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent())
            throw new Exception("User is not found in database");
        else
            return user.get();
    }
    @PostMapping
    public User userCreate( @RequestBody User user){
        User user1 = userRepository.save(user);
        return user1;
    }

    @PutMapping("/{id}")
    public User userUpdate(@PathVariable String id, @RequestBody User user) throws Exception {
        if (userRepository.existsById(id)) {
            user.setId(id);
            User user1 = userRepository.save(user);
            return user1;
        } else
            throw new Exception("User not exist");
    }

    @DeleteMapping("/{id}")
    public void userDelete(@PathVariable String id ){
        userRepository.deleteById(id);
    }


}
