package com.blog.blog.services;

import com.blog.blog.models.Ad;
import com.blog.blog.repositories.AdRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdSvc {

    AdRepo adDao;

    public AdSvc(AdRepo adDao) {
        this.adDao = adDao;
    }

    public List<Ad> giveMeAds() {
        return adDao.findAll();
    }
}