package com.example.f4yproject.repository;

import com.example.f4yproject.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    @Query(value = "{_id: '?0'}")
    public Comment findCommentByID(String ID);

    @Query(value = "{threadID: '?0'")
    public Comment findCommentByThreadID(String ID);

    @Query(value = "{ownerID: '?0'")
    public Comment findCommentByOwnerID(String ID);

}
