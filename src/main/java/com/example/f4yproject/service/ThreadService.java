package com.example.f4yproject.service;

import com.example.f4yproject.pojo.Thread;
import com.example.f4yproject.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadService {

    @Autowired
    ThreadRepository threadRepository;

    public List<Thread> getAllThread(){
        return threadRepository.findAll();
    }

    public Thread getThreadByID(String ID){
        return threadRepository.findThreadByID(ID);
    }

    public Thread getThreadByTopic(String topic){
        return threadRepository.findThreadByTopic(topic);
    }

}
