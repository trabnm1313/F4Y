package com.example.f4yproject.service;

import com.example.f4yproject.pojo.Comment;
import com.example.f4yproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Comment createComment(Comment comment){

        //IF _id is exists then it's UPDATE not CREATE
        if(comment.get_id() != null) return null;

        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment){

        //IF _id is not exists then it's CREATE not UPDATE
        if(comment.get_id() == null) return null;

        return commentRepository.save(comment);
    }

    public boolean deleteComment(Comment comment){

        boolean isDeleted;

        try{
            commentRepository.delete(comment);
            isDeleted = true;
        }catch(Exception e){
            e.printStackTrace();
            isDeleted = false;
        }

        return isDeleted;
    }


}
