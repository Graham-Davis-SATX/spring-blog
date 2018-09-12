package com.blog.blog.zpets.repositories;


import com.blog.blog.zpets.models.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepo extends CrudRepository<Pet, Long> {

    List<Pet> findAll();

}
