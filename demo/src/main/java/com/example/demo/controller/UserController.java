package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.services.UserService;
import com.example.demo.utils.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> list() {
        return userService.listAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User user = userService.getUser(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody User user) {
        if (!user.getFull_name().matches("^[\\.a-zA-Z0-9, ]*$")) {
            return new ResponseEntity<String>(ErrorMessage.FULLNAME_INVALID, HttpStatus.BAD_REQUEST);
        }
        if (user.getEmail_address().matches("^[A-Z0-9+_.-]+@[A-Z0-9.-]+$")) {
            return new ResponseEntity<String>(ErrorMessage.EMAIL_INVALID, HttpStatus.BAD_REQUEST);
        }
        if (!user.getMobile_number().matches("^(09|\\+639)\\d{9}$")) {
            return new ResponseEntity<String>(ErrorMessage.MOBILE_INVALID, HttpStatus.BAD_REQUEST);
        }
        if (user.getAge() < 18) {
            return new ResponseEntity<String>(ErrorMessage.AGE_INVALID, HttpStatus.BAD_REQUEST);
        }
        userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            User existUser = userService.getUser(id);
            user.setId(id);
            userService.saveUser(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(ErrorMessage.NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>("Successfully deleted!", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(ErrorMessage.NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }
}