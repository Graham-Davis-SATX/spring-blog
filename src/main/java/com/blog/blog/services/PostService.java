package com.blog.blog.services;

import com.blog.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    List<Post> posts = new ArrayList<>();

    public PostService() {
        createStarterPosts();
    }

    public Post findOne(long id) {
        return posts.get((int) id - 1);
    }

    public List<Post> findAll() {
        return posts;
    }

    private void createStarterPosts() {
        posts.add(new Post("My family", "they're all amazing"));
        posts.add(new Post("My pets","dogs, horses, donkeys, and llamas"));
        posts.add(new Post("My travels", "far and wide - europe next"));
        posts.add(new Post("My bucklist", "climbing the tallest mountains, hiking the longest trail"));
    }

}
