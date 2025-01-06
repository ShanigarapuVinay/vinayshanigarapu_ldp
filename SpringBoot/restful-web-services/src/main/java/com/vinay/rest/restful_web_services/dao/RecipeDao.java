package com.vinay.rest.restful_web_services.dao;

import com.vinay.rest.restful_web_services.entity.Recipe;

import java.util.List;

public interface RecipeDao {
    List<Recipe> findAll();
    Recipe findById(int id);
    void save(Recipe recipe);
    void deleteById(int id);
}
