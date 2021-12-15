package com.example.f4yproject.controller;

import com.example.f4yproject.pojo.User;
import com.example.f4yproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void userLogin(@RequestBody User user) {
        System.out.println(user.toString());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void userSignUp(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        System.out.println(username);
        System.out.println(password);
    }
}
