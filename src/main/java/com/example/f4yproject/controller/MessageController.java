package com.example.f4yproject.controller;

import com.example.f4yproject.pojo.Message;
import com.example.f4yproject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/getMessages", method = RequestMethod.GET)
    public void getMessages() {
        List<Message> messages = messageService.getAllMessage();
        System.out.println(messages.toString());
    }

    @RequestMapping(value = "/getMessage/byID/{id}", method = RequestMethod.GET)
    public void getMessageByID(@PathVariable("id") String id) {
        Message message = messageService.getMessageByID(id);
        System.out.println(message.toString());
    }

    @RequestMapping(value = "/getMessage/byTopic/{topic}", method = RequestMethod.GET)
    public void getMessageByTopic(@PathVariable("topic") String topic) {
        Message message = messageService.getMessageByTopic(topic);
        System.out.println(message.toString());
    }
}
