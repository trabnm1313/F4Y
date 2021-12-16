package com.example.f4yproject.repository;

import com.example.f4yproject.pojo.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

    @Query(value = "{_id: '?0'}")
    public Message findMessageByID(String ID);

    @Query(value = "{topic: '?0', timeStamp: {$gte: ?1}}")
    public List<Message> findAllMessageByTopic(String topic, Instant since);

}
