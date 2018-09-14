package com.blog.blog.zpets.repositories;

import com.blog.blog.zpets.models.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepo extends CrudRepository<Vet, Long> {

}