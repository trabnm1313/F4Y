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
    public List<Thread> getThreads() {
        List<Thread> threads = threadService.getAllThread();
        System.out.println(threads.toString());
        return threads;
    }

    @RequestMapping(value = "/getThread/byID/{id}", method = RequestMethod.GET)
    public Thread getThreadByID(@PathVariable("id") String id) {
        Thread thread = threadService.getThreadByID(id);
        System.out.println(thread.toString());
        return thread;
    }

    @RequestMapping(value = "/getThread/byTopic/{topic}", method = RequestMethod.GET)
    public Thread getThreadByTopic(@PathVariable("topic") String topic) {
        Thread thread = threadService.getThreadByTopic(topic);
        System.out.println(thread.toString());
        return thread;
    }
}
