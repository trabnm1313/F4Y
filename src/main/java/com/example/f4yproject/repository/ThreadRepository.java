package com.example.f4yproject.repository;

import com.example.f4yproject.pojo.Thread;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadRepository extends MongoRepository<Thread, String> {}
