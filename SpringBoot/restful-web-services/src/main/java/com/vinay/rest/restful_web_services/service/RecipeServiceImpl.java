package com.vinay.rest.restful_web_services.service;

import com.vinay.rest.restful_web_services.entity.Recipe;
import com.vinay.rest.restful_web_services.dao.RecipeDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService{

    private RecipeDao recipeDao;
    @Override
    @Transactional
    public List<Recipe> findAll() {
        return recipeDao.findAll();
    }

    @Override
    @Transactional
    public Recipe findById(int id) {
        return recipeDao.findById(id);
    }

    @Override
    @Transactional
    public void save(Recipe recipe) {
        recipeDao.save(recipe);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        recipeDao.deleteById(id);
    }
}
