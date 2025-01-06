package com.vinay.rest.restful_web_services.repository;

import com.vinay.rest.restful_web_services.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

//@RepositoryRestResource(path = "items")
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    Optional<Recipe> findByName(String name);
}
