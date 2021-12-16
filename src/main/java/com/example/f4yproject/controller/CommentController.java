package com.example.f4yproject.controller;

import com.example.f4yproject.pojo.Comment;
import com.example.f4yproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
    public ResponseEntity<?> createComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.createComment(comment));
    }

    @RequestMapping(value = "/updateComment", method = RequestMethod.POST)
    public ResponseEntity<?> updateComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.updateComment(comment));
    }

    @RequestMapping(value = "/deleteComment", method = RequestMethod.POST)
    public boolean deleteComment(@RequestBody Comment comment) {
        return commentService.deleteComment(comment);
    }
}
