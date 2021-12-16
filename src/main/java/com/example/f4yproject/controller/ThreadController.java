package com.example.f4yproject.controller;

import com.example.f4yproject.pojo.Thread;
import com.example.f4yproject.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @RequestMapping(value = "/createThread", method = RequestMethod.POST)
    public ResponseEntity<?> createThread(@RequestBody Thread thread) {
        return ResponseEntity.ok(threadService.createThread(thread));
    }

    @RequestMapping(value = "/updateThread", method = RequestMethod.POST)
    public ResponseEntity<?> updateThread(@RequestBody Thread thread) {
        return ResponseEntity.ok(threadService.updateThread(thread));
    }

    @RequestMapping(value = "/deleteThread", method = RequestMethod.POST)
    public boolean deleteThread(@RequestBody Thread thread) {
        return threadService.deleteThread(thread);
    }
}
