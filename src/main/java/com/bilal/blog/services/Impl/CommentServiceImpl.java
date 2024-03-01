package com.bilal.blog.services.Impl;

import com.bilal.blog.entities.Comment;
import com.bilal.blog.entities.Post;
import com.bilal.blog.exceptions.ResourceNotFoundException;
import com.bilal.blog.payloads.CommentDto;
import com.bilal.blog.repositories.CommentRepo;
import com.bilal.blog.repositories.PostRepo;
import com.bilal.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", " post id ", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment com = this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment ", "comment id ", commentId));
        this.commentRepo.delete(com);

    }
}
