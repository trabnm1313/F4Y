package com.example.f4yproject.service;

import com.example.f4yproject.pojo.Message;
import com.example.f4yproject.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public Message createMessage(Message message){

        //IF _id is exists then it's UPDATE not CREATE
        if(message.get_id() != null) return null;

        return messageRepository.save(message);
    }

    public Message updateMessage(Message message){

        //IF _id is not exists then it's CREATE not UPDATE
        if(message.get_id() == null) return null;

        return messageRepository.save(message);
    }

    public boolean deleteMessage(Message message){

        boolean isDeleted;

        try{
            messageRepository.delete(message);
            isDeleted = true;
        }catch(Exception e){
            e.printStackTrace();
            isDeleted = false;
        }

        return isDeleted;
    }

}
