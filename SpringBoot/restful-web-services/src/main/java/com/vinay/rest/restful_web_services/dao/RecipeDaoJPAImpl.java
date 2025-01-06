package com.vinay.rest.restful_web_services.dao;

import com.vinay.rest.restful_web_services.entity.Recipe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
@AllArgsConstructor
public class RecipeDaoJPAImpl implements RecipeDao {

    private EntityManager entityManager;

    @Override
    public List<Recipe> findAll() {
        Query query = entityManager.createQuery("from Recipe");
        return query.getResultList();
    }

    @Override
    public Recipe findById(int id) {
        Recipe recipe = entityManager.find(Recipe.class, id);
        if(recipe == null)
            throw new RuntimeException("Recipe with id " + id + " not found");
        return recipe;
    }

    @Override
    public void save(Recipe recipe) {
        Recipe dbRecipe = entityManager.merge(recipe);

        // update with id from db ..so we can get generated id for save/update
        recipe.setId(dbRecipe.getId());
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("delete from Recipe where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        if (result == 0) {
            throw new RuntimeException("Review with ID " + id + " not found");
        }
    }
}
