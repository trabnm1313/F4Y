package com.example.f4yproject.controller;

import com.example.f4yproject.pojo.Message;
import com.example.f4yproject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/createMessage", method = RequestMethod.POST)
    public ResponseEntity<?> createMessage(@RequestBody Message message) {
        return ResponseEntity.ok(messageService.createMessage(message));
    }

    @RequestMapping(value = "/updateMessage", method = RequestMethod.POST)
    public ResponseEntity<?> updateMessage(@RequestBody Message message) {
        return ResponseEntity.ok(messageService.updateMessage(message));
    }

    @RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
    public boolean deleteMessage(@RequestBody Message message) {
        return messageService.deleteMessage(message);
    }
}
