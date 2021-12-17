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
    public List<Comment> getComments() {
        List<Comment> comments = commentService.getAllComment();
        return comments;
    }

    @RequestMapping(value = "/getComment/byThreadID/{id}", method = RequestMethod.GET)
    public List<Comment> getCommentByThreadID(@PathVariable("id") String id) {
        List<Comment> comments = commentService.getCommentByThreadID(id);
        return comments;
    }

    @RequestMapping(value = "/getComment/byOwnerID/{id}", method = RequestMethod.GET)
    public Comment getCommentByOwnerID(@PathVariable("id") String id) {
        Comment comments = commentService.getCommentByOwnerID(id);
        return comments;
    }
}
