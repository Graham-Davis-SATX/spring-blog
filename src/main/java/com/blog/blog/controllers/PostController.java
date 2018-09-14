package com.blog.blog.controllers;

import com.blog.blog.models.Post;
import com.blog.blog.repositories.PostRepo;
import com.blog.blog.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    PostRepo postDao;
    UserRepo userDao;

    public PostController(PostRepo postDao, UserRepo userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }


    // posts

    @GetMapping("/posts")
    private String showAllPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/all-posts";
    }

    @GetMapping("/posts/{id}")
    private String showPost(@PathVariable long id, Model model) {
//        Post post = postsRepo.findOne(id);
        model.addAttribute("post", postDao.findOne(id));
        return "posts/show-post";
    }


    // posts and details

    @GetMapping("/posts/{id}/create")
    private String createPost(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "posts/create";
    }

    @PostMapping("/posts/{id}/create")
    private String insertPost(@PathVariable long id, @ModelAttribute Post post) {
//        post.setUser(userRepo.findOne(1L));
        postDao.save(post);
        return "redirect:/posts/" + id;
    }
//
//
//    @GetMapping("/posts/{id}/edit")
//    private String postEditForm(@PathVariable long id, Model model) {
//        model.addAttribute("post", postDao.findOne(id));
//        return "posts/create";
//    }
//
//    @PostMapping("/posts/{id}/edit")
//    private String updatePost(@PathVariable long id, @ModelAttribute Post post) {
//        postDao.save(post);
//        return "redirect:/posts" + id;
//    }
//
//    @PostMapping("/posts/delete")
//    private String deletePost(@PathVariable long id){
//        postDao.delete(id);
//        return "redirect:/posts" + id;
//    }

//    @GetMapping("/find-user/{query}")
//    @ResponseBody
//    private String findUser(@PathVariable String query){
//        User user = userDao.findByUsername(query);
//        System.out.println("user.getEmail() = " + user.getEmail());
//        return "testing find by username";
//    }



}
