package com.example.f4yproject.controller;

import com.example.f4yproject.pojo.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void userLogin(@RequestBody User user) {
        System.out.println(user.toString());
    }

    @RequestMapping(value = "/signup/{username}/{password}", method = RequestMethod.GET)
    public void userSignUp(@PathVariable("username") String username,
                           @PathVariable("password") String password) {
        System.out.println(username);
        System.out.println(password);
    }
}
