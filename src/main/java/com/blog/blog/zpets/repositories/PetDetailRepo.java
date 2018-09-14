package com.blog.blog.zpets.repositories;


import com.blog.blog.zpets.models.PetDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetDetailRepo extends CrudRepository<PetDetail, Long> {

}