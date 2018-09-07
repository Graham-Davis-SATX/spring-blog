package com.blog.blog.controllers;

import com.blog.blog.models.Ad;
import com.blog.blog.services.AdsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdsController {

    private final AdsService adsSvc;

    public AdsController(AdsService adsSvc) {
        this.adsSvc = adsSvc;
    }

    @GetMapping("/ads/{id}")
    public String showAd(@PathVariable long id, Model viewModel) {
        Ad ad = adsSvc.findOne(id);
        viewModel.addAttribute("ad", ad);
        return "ads/show";
    }

    @GetMapping("/ads")
    public String showAllAds(Model viewModel) {
        viewModel.addAttribute("ads", adsSvc.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/create")
    public String showCreateForm(Model viewModel) {
            viewModel.addAttribute("ad", new Ad("Awesome Pug",  "He is grunty"));
        return "ads/create";
    }

    @PostMapping("/ads/save")
    public String createAd(@ModelAttribute Ad ad){
        adsSvc.save(ad);
        return "redirect:/ads";
    }

}
