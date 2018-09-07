package com.blog.blog.controllers;

import com.blog.blog.models.Post;
import com.blog.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@Controller
public class PostController {

    private final PostService postSvc;

    public PostController(PostService postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model viewModel) {
        Post post = postSvc.findOne(id);
        viewModel.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts")
    public String showAllPosts(Model viewModel) {
        viewModel.addAttribute("posts", postSvc.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/create")
    public String postCreateForm(Model viewModel) {
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String insertPost(@ModelAttribute Post post) {
        postSvc.save(post);
        return "redirect:/posts";
    }

//    @GetMapping("/posts/${id}/edit")
//    public String postEditForm(@PathVariable long id, Model viewModel) {
//        viewModel.addAttribute("post", postSvc.findOne(id));
//        return "posts/create";
//    }

//    @GetMapping("/posts/${id}/edit")
//    public String updatePost(@PathVariable Post post) {
//        System.out.println("Post updated!");
//        return "redirect:/posts";
//    }

}
