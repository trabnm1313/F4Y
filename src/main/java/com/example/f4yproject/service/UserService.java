package com.example.f4yproject.service;

import com.example.f4yproject.pojo.User;
import com.example.f4yproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user){

        //IF _id is exists then it's UPDATE not CREATE
        if(user.get_id() != null) return null;

        return userRepository.save(user);
    }

    public User updateUser(User user){

        //IF _id is exists then it's CREATE not UPDATE
        if(user.get_id() == null) return null;

        return userRepository.save(user);
    }

    public boolean deleteUser(User user){

        boolean isDeleted;

        try{
            userRepository.delete(user);
            isDeleted = true;
        }catch(Exception e){
            e.printStackTrace();
            isDeleted = false;
        }

        return isDeleted;
    }

    public String login(MultiValueMap<String, String> auth){

        Map<String, String> authValue = auth.toSingleValueMap();

        String username = authValue.get("username");
        String password = authValue.get("password");

        User user = userRepository.login(username, password);

        if(user == null) return null;

        return user.get_id();
    }

    public User authenticate(String authKey){

        return userRepository.findUserByID(authKey);
    }

}
