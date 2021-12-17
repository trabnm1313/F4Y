package com.example.f4yproject.service;

import com.example.f4yproject.pojo.Comment;
import com.example.f4yproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getAllComment(){
        return commentRepository.findAll();
    }

    public Comment getCommentByID(String ID){
        return commentRepository.findCommentByID(ID);
    }

    public List<Comment> getCommentByThreadID(String ID){
        return commentRepository.findAllCommentByThreadID(ID);
    }

    public Comment getCommentByOwnerID(String ID) {
        return commentRepository.findCommentByOwnerID(ID);
    }
}
