package com.vinay.rest.restful_web_services.service;

import com.vinay.rest.restful_web_services.entity.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> findAll();
    Recipe findById(int id);
    void save(Recipe recipe);
    void deleteById(int id);
}
