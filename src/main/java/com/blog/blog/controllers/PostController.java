package com.blog.blog.controllers;

import com.blog.blog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

//    GET	/posts	posts index page
//    GET	/posts/{id}	view an individual post
//    GET	/posts/create	view the form for creating a post
//    POST	/posts/create	create a new post

    List<Post> posts = new ArrayList<>();

    public PostController() {
        posts.add(new Post("My family", "they're all amazing"));
        posts.add(new Post("My pets","dogs, horses, donkeys, and llamas"));
        posts.add(new Post("My travels", "far and wide - europe next"));
        posts.add(new Post("My bucklist", "climbing the tallest mountains, hiking the longest trail"));
    }

    @GetMapping("/posts")
    public String index(Model viewModel) {
        viewModel.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model viewModel) {
        Post post = posts.get( (int) id - 1); //posts are indexed at 0 so you need to add the -1 to force the first post to show
        viewModel.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String show() {
        return "Showing form to create new post!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "New post was created!";
    }
}
