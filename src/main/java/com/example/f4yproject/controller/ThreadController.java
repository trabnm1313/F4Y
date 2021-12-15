package com.example.f4yproject.controller;

import com.example.f4yproject.pojo.Thread;
import com.example.f4yproject.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadController {
    @Autowired
    private ThreadService threadService;

    @RequestMapping(value = "/getThreads", method = RequestMethod.GET)
    public void getThreads() {
        System.out.println("return all threads");
    }

    @RequestMapping(value = "/createThread", method = RequestMethod.POST)
    public void createThread(@RequestBody Thread thread) {
        System.out.println(thread.toString());
    }

    @RequestMapping(value = "/updateThread", method = RequestMethod.POST)
    public void updateThread(@RequestBody Thread thread) {
        System.out.println(thread.toString());
    }

    @RequestMapping(value = "/deleteThread", method = RequestMethod.POST)
    public void deleteThread(@RequestBody Thread thread) {
        System.out.println(thread.toString());
    }
}
