package com.blog.blog.repositories;

import com.blog.blog.models.Ad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepo extends CrudRepository<Ad, Long> {

    List<Ad> findAll();

//    List<Ad> findByTitleContainingOrDescriptionContaining(String string1, String string2);
//
//    @Query("from Ad a where a.id > ?1")
//    List<Ad> findCustom(long id);

}