package com.blog.blog.services;

import com.blog.blog.models.Ad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdsService {
    private List<Ad> ads;

    public AdsService() {
        ads = new ArrayList<>();
            createAds();
    }

    public Ad save(Ad ad){
        ad.setId(ads.size() + 1);
        ads.add(ad);
        return ad;
    }

    public Ad findOne(long id) {
        return ads.get((int)(id - 1));
    }

    public List<Ad> findAll() {
       return ads;
    }

    public void createAds(){
        ads.add(new Ad("PS4", "brand new"));
        ads.add(new Ad("Xbox360", "slightly new"));
        ads.add(new Ad("Nintendo", "not new"));
    }

}
