package com.example.f4yproject.controller;

import com.example.f4yproject.pojo.User;
import com.example.f4yproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> userLogin(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void userSignUp(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        System.out.println(username);
        System.out.println(password);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public boolean deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }
}
