package com.bilal.blog.controllers;

import com.bilal.blog.payloads.ApiResponse;
import com.bilal.blog.payloads.CommentDto;
import com.bilal.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId){
        CommentDto createComment = this.commentService.createComment(comment, postId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer postId){
        this.commentService.deleteComment(postId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted Successfully !!", true), HttpStatus.OK);
    }
}
