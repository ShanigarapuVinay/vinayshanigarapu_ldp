package com.vinay.rest.restful_web_services.dao;

import com.vinay.rest.restful_web_services.entity.Recipe;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RecipeDaoHibernateImpl implements RecipeDao {

    private EntityManager entityManager;

    @Override
    public List<Recipe> findAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Recipe> query = session.createQuery("from Recipe", Recipe.class);

        return query.getResultList();
    }

    @Override
    public Recipe findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Recipe recipe = session.get(Recipe.class, id);
        if(recipe == null)
            throw new RuntimeException("Recipe with id " + id + " not found");
        return recipe;
    }

    @Override
    public void save(Recipe recipe) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(recipe);
    }

    @Override
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Recipe where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        if (result == 0) {
            throw new RuntimeException("Review with ID " + id + " not found");
        }
    }
}
