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

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = userService.getAllUser();
        System.out.println(users.toString());
        return users;
    }

    @RequestMapping(value = "/getUser/byID/{id}", method = RequestMethod.GET)
    public User getUserByID(@PathVariable("id") String id) {
        User user = userService.getUserByID(id);
        System.out.println(user.toString());
        return user;
    }

    @RequestMapping(value = "/getUser/byNickname/{nickname}", method = RequestMethod.GET)
    public User getUserByNickname(@PathVariable("nickname") String nickname) {
        User user = userService.getUserByNickName(nickname);
        System.out.println(user.toString());
        return user;
    }

    @RequestMapping(value = "/getUser/byUsername/{username}", method = RequestMethod.GET)
    public User getUserByUsername(@PathVariable("username") String username) {
        User user = userService.getUserByUsername(username);
        System.out.println(user.toString());
        return user;
    }
}
