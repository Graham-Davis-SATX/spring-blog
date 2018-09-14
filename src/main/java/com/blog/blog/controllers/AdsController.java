package com.blog.blog.controllers;

import com.blog.blog.repositories.AdRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdsController {

    AdRepo adDao;

    public AdsController(AdRepo adDao) {
        this.adDao = adDao;
    }

    // ads

    @GetMapping("/ads")
    private String showAllAds(Model model) {
////        testing to see which user is posting an ad in the terminal
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("User email: " + user.getEmail());
        model.addAttribute("ads", adDao.findAll());
        return "ads/all-ads";
    }

    @GetMapping("/ads/{id}")
    private String showAd(@PathVariable long id, Model model) {
        model.addAttribute("ad", adDao.findOne(id));
        return "ads/show-ad";
    }



//    @GetMapping("/ads")
//    public String showAllAds(Model viewModel) {
//        viewModel.addAttribute("ads", adsSvc.findAll());
//        return "ads/index";
//    }
//
//    @GetMapping("/ads/{id}")
//    public String showAd(@PathVariable long id, Model viewModel) {
//        Ad ad = adsSvc.findOne(id);
//        viewModel.addAttribute("ad", ad);
//        return "ads/show";
//    }


//    @GetMapping("/ads/create")
//    public String showCreateForm(Model viewModel) {
//            viewModel.addAttribute("ad", new Ad("Awesome Pug",  "He is grunty"));
//        return "ads/create";
//    }
//
//    @PostMapping("/ads/save")
//    public String createAd(@ModelAttribute Ad ad){
//        adsSvc.save(ad);
//        return "redirect:/ads";
//    }

}
