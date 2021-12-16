package com.example.f4yproject.service;

import com.example.f4yproject.pojo.Thread;
import com.example.f4yproject.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreadService {

    @Autowired
    ThreadRepository threadRepository;

    public Thread createThread(Thread thread){

        //IF _id is exists then it's UPDATE not CREATE
        if(thread.get_id() != null) return null;

        return threadRepository.save(thread);
    }

    public Thread updateThread(Thread thread){

        //IF _id is exists then it's CREATE not UPDATE
        if(thread.get_id() == null) return null;

        return threadRepository.save(thread);
    }

    public boolean deleteThread(Thread thread){

        boolean isDeleted;

        try{
            threadRepository.delete(thread);
            isDeleted = true;
        }catch(Exception e){
            e.printStackTrace();
            isDeleted = false;
        }

        return isDeleted;
    }

}
