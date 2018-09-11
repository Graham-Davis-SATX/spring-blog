package com.blog.blog.services;

import com.blog.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
            createStarterPosts();
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int) id - 1);
    }

    public List<Post> findAll() {
        return posts;
    }

    private void createStarterPosts() {
        posts.add(new Post(1,"My family", "they're all amazing"));
        posts.add(new Post(2,"My pets","dogs, horses, donkeys, and llamas"));
        posts.add(new Post(3,"My travels", "far and wide - europe next"));
        posts.add(new Post(4,"My bucklist", "climbing the tallest mountains, hiking the longest trail"));
    }

}
