package com.example.f4yproject.controller;

import com.example.f4yproject.pojo.Comment;
import com.example.f4yproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/getComments", method = RequestMethod.GET)
    public void getComments() {
        List<Comment> comments = commentService.getAllComment();
        System.out.println(comments.toString());
    }

    @RequestMapping(value = "/getComment/ByThreadID/{id}", method = RequestMethod.GET)
    public void getCommentByThreadID(@PathVariable("id") String id) {
        Comment comments = commentService.getCommentByThreadID(id);
        System.out.println(comments.toString());
    }

    @RequestMapping(value = "/getComment/ByOwnerID/{id}", method = RequestMethod.GET)
    public void getCommentByOwnerID(@PathVariable("id") String id) {
        Comment comments = commentService.getCommentByOwnerID(id);
        System.out.println(comments.toString());
    }
}
