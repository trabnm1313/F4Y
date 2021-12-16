package com.example.f4yproject.controller;

import com.example.f4yproject.pojo.Thread;
import com.example.f4yproject.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @RequestMapping(value = "/getThreads", method = RequestMethod.GET)
    public void getThreads() {
        List<Thread> threads = threadService.getAllThread();
        System.out.println(threads.toString());
    }

    @RequestMapping(value = "/getThread/byTopic/{topic}", method = RequestMethod.GET)
    public void getThreadByTopic(@PathVariable("topic") String topic) {
        Thread thread = threadService.getThreadByTopic(topic);
        System.out.println(thread.toString());
    }
}
