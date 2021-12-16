package com.example.f4yproject.controller;

import com.example.f4yproject.pojo.User;
import com.example.f4yproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void userLogin(@RequestBody User user) {
        boolean status = userService.registerUser(user);
        System.out.println(status);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void userSignUp(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        System.out.println(username);
        System.out.println(password);
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public void getUsers() {
        List<User> users = userService.getAllUser();
        System.out.println(users.toString());
    }

    @RequestMapping(value = "/getUser/byNickName/{nickname}", method = RequestMethod.GET)
    public void getUserByNickName(@PathVariable("nickname") String nickname) {
        User user = userService.getUserByNickName(nickname);
        System.out.println(user.toString());
    }

    @RequestMapping(value = "/getUser/byUsername/{username}", method = RequestMethod.GET)
    public void getUserByUsername(@PathVariable("username") String username) {
        User user = userService.getUserByUsername(username);
        System.out.println(user.toString());
    }
}
