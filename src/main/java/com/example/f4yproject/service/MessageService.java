package com.example.f4yproject.service;

import com.example.f4yproject.pojo.Message;
import com.example.f4yproject.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public List<Message> getAllMessage(){
        return messageRepository.findAll();
    }

    public Message getMessageByID(String ID){
        return messageRepository.findMessageByID(ID);
    }

    public List<Message> getAllMessageByTopic(String topic, Instant since){
        return messageRepository.findAllMessageByTopic(topic, since);
    }

}
