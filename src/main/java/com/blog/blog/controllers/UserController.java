package com.blog.blog.controllers;

import com.blog.blog.models.Post;
import com.blog.blog.models.User;
import com.blog.blog.repositories.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    UserRepo userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepo userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/your-posts")
    @ResponseBody
    public String findUser() {

        User user = userDao.findOne(1L);
        List<Post> posts = user.getPost();

        for (Post post : posts) {
            System.out.println("post.getId() " + post.getId());
        }
            return "your-posts";
    }
}
