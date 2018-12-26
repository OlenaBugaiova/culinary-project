package com.olenabugaiova.tasteit.dao;

import com.olenabugaiova.tasteit.model.Dimension;
import com.olenabugaiova.tasteit.model.DishIngredientDetails;
import com.olenabugaiova.tasteit.model.Ingredient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by elena on 07/12/18.
 */

@Repository
public class IngredientDetailsDAO implements IIngredientDetailsDAO {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ingredient> getAllIngredients() {
        String hqlQuery = "Select i FROM Ingredient i ORDER BY i.name";
        return (List<Ingredient>) entityManager.createQuery(hqlQuery).getResultList();
    }

    @Override
    public List<Dimension> getAllDimensions() {
        String hqlQuery = "Select d FROM Dimension d ORDER BY d.name";
        return (List<Dimension>) entityManager.createQuery(hqlQuery).getResultList();
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        String hql = "Select i FROM Ingredient i WHERE i.name = ?";
        List<Ingredient> ingredients = entityManager.createQuery(hql).setParameter(0, name).getResultList();
        return ingredients.size() == 1 ? ingredients.get(0) : null;
    }

    @Override
    public Ingredient getIngredientById(long ingredientId) {
        String hql = "Select i FROM Ingredient i WHERE i.id = ?";
        List<Ingredient> ingredients = entityManager.createQuery(hql).setParameter(0, ingredientId).getResultList();
        return ingredients.size() == 1 ? ingredients.get(0) : null;
    }

    @Override
    public Dimension getDimensionByName(String name) {
        String hql = "Select d FROM Dimension d WHERE d.name = ?";
        List<Dimension> dimensions = entityManager.createQuery(hql).setParameter(0, name).getResultList();
        return dimensions.size() == 1 ? dimensions.get(0) : null;
    }

    @Override
    public Dimension getDimensionById(long dimensionId) {
        String hql = "Select d FROM Dimension d WHERE d.id = ?";
        List<Dimension> dimensions = entityManager.createQuery(hql).setParameter(0, dimensionId).getResultList();
        return dimensions.size() == 1 ? dimensions.get(0) : null;
    }

    @Override
    public void saveIngredientDetails(DishIngredientDetails dishIngredientDetails) {
        entityManager.persist(dishIngredientDetails);
    }

    @Override
    public List<DishIngredientDetails> getIngredientsForDish(long dishId) {
        String hql = "Select did FROM DishIngredientDetails did WHERE did.dish.id = ?";
        List<DishIngredientDetails> ingredientDetails = entityManager.createQuery(hql).setParameter(0, dishId).getResultList();
        return ingredientDetails;
    }
}
