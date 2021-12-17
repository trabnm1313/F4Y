package com.example.f4yproject.controller;

import com.example.f4yproject.pojo.Message;
import com.example.f4yproject.service.MessageService;
import com.vaadin.collaborationengine.CollaborationMessage;
import com.vaadin.collaborationengine.CollaborationMessageInput;
import com.vaadin.collaborationengine.CollaborationMessageList;
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
    public List<Message> getMessages() {
        List<Message> messages = messageService.getAllMessage();
        return messages;
    }

    @RequestMapping(value = "/getMessage/byID/{id}", method = RequestMethod.GET)
    public Message getMessageByID(@PathVariable("id") String id) {
        Message message = messageService.getMessageByID(id);
        return message;
    }

    @RequestMapping(value = "/getMessage/byTopic/{topic}", method = RequestMethod.GET)
    public Message getMessageByTopic(@PathVariable("topic") String topic) {
        Message message = messageService.getMessageByTopic(topic);
        return message;
    }
}
