package com.example.projectview.post;

import com.example.projectview.model.Thread;
import com.example.projectview.view.main.MainView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PostConsumer {
    public List<Thread> threads = new ArrayList<>();

    public PostConsumer() {
        getThreads();
    }

    @RabbitListener(queues = "postQueue")
    public void getThreads() {
        System.out.println("Fetch data");
        JsonNode out = WebClient.create()
                .get()
                .uri("http://localhost:9090/getThreads")
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();

        ObjectMapper mapper = new ObjectMapper();
        this.threads = mapper.convertValue(
                out,
                new TypeReference<List<Thread>>() {}
        );
        Collections.reverse(this.threads);
    }

    public List<Thread> getData() {
        return this.threads;
    }

}
