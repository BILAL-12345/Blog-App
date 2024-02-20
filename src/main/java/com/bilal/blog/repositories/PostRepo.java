package com.bilal.blog.repositories;

import com.bilal.blog.entities.Category;
import com.bilal.blog.entities.Post;
import com.bilal.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}
