package com.vinay.rest.restful_web_services.controller;

import com.vinay.rest.restful_web_services.entity.Recipe;
import com.vinay.rest.restful_web_services.service.RecipeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@AllArgsConstructor
@RequestMapping("/cook-book")
public class RecipeController {

    private RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes(){
        return recipeService.findAll();
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipeById(@PathVariable int id){
        Recipe recipe = recipeService.findById(id);
        return  recipe;
    }

    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe recipe){
        // setting the id as 0 if the user enters id in the Request body
        recipe.setId(0);
        recipeService.save(recipe);
        return recipe;
    }

    // Method 1
    @PutMapping("/recipes/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable int id, @RequestBody Recipe newRecipe){
        Recipe recipe = recipeService.findById(id);

        recipe.setName(newRecipe.getName());
        recipe.setProcess(newRecipe.getProcess());
        recipe.setRating(newRecipe.getRating());

        recipeService.save(recipe);
        return ResponseEntity.ok(recipe);
    }

    // Method 2
    @PutMapping("/recipes")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe){
        recipeService.save(recipe);
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/recipes/{id}")
    public String deleteRecipe(@PathVariable int id){
        recipeService.deleteById(id);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Recipe of id = ");
        stringBuilder.append(id);
        stringBuilder.append(" deleted successfully..");
        return stringBuilder.toString();
    }
}