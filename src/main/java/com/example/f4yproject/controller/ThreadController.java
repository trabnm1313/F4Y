package com.example.f4yproject.controller;

import com.example.f4yproject.pojo.Thread;
import com.example.f4yproject.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @RequestMapping(value = "/getThreads", method = RequestMethod.GET)
    public List<Thread> getThreads() {
        List<Thread> threads = threadService.getAllThread();
        return threads;
    }

    @RequestMapping(value = "/getThread/byID/{id}", method = RequestMethod.GET)
    public Thread getThreadByID(@PathVariable("id") String id) {
        Thread thread = threadService.getThreadByID(id);
        return thread;
    }

    @RequestMapping(value = "/getThread/byTopic/{topic}", method = RequestMethod.GET)
    public Thread getThreadByTopic(@PathVariable("topic") String topic) {
        Thread thread = threadService.getThreadByTopic(topic);
        return thread;
    }

    @RequestMapping(value = "/likeThread/{id}", method = RequestMethod.GET)
    public int likeThread(@PathVariable("id") String id) {
        Thread thread = threadService.getThreadByID(id);
        thread.setLike(thread.getLike() + 1);
        Thread out = WebClient.create()
                .post()
                .uri("http://localhost:8080/updateThread")
                .body(Mono.just(thread), Thread.class)
                .retrieve()
                .bodyToMono(Thread.class)
                .block();
        System.out.println(thread.getLike());
        return thread.getLike();
    }
}
