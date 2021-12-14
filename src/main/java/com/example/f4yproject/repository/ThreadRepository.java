package com.example.f4yproject.repository;

import com.example.f4yproject.pojo.Thread;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadRepository extends MongoRepository<Thread, String> {

    @Query(value = "{_id: '?0'}")
    public Thread findThreadByID(String ID);

    @Query(value = "{topic: '?0'}")
    public Thread findThreadByTopic(String topic);

}
