package com.blog.blog.controllers;

import com.blog.blog.models.Post;
import com.blog.blog.models.User;
import com.blog.blog.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/your-posts")
    @ResponseBody
    public String findUser() {

        User user = userRepo.findOne(1L);
        List<Post> posts = user.getPost();

        for (Post post : posts) {
            System.out.println("post.getId() " + post.getId());
        }
            return "your-posts";
    }
}
