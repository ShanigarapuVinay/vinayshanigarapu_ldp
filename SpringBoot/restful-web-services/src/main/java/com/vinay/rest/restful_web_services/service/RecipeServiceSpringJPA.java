package com.vinay.rest.restful_web_services.service;

import com.vinay.rest.restful_web_services.entity.Recipe;
import com.vinay.rest.restful_web_services.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
//@Primary
@AllArgsConstructor
public class RecipeServiceSpringJPA implements RecipeService{

    private RecipeRepository recipeRepository;
    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findById(int id) {
        Optional<Recipe> result = recipeRepository.findById(id);
        Recipe recipe = null;
        if(result.isPresent())
            recipe = result.get();
        else
            throw new RuntimeException("Did not find recipe with id - " + id);
        return recipe;
    }

    @Override
    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public void deleteById(int id) {
        recipeRepository.deleteById(id);
    }
}
