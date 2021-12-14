package com.example.f4yproject.service;

import com.example.f4yproject.pojo.User;
import com.example.f4yproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserByID(String ID){
        return userRepository.findUserByID(ID);
    }

    public User getUserByNickName(String nickname){
        return userRepository.findUserByNickName(nickname);
    }

    public User getUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    //TODO: Login

    public Boolean registerUser(User user){

        //IF Username is already exists ; return false
        if( this.getUserByUsername(user.getUsername()) == null) return false;

        //IF Password is empty ; return false
        if( user.getPassword().equals("") ) return false;

        userRepository.save(user);
        return true;

    }


}
