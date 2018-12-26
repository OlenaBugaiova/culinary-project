package com.olenabugaiova.tasteit.service;

import com.olenabugaiova.tasteit.dao.IIngredientDetailsDAO;
import com.olenabugaiova.tasteit.model.Dimension;
import com.olenabugaiova.tasteit.model.DishIngredientDetails;
import com.olenabugaiova.tasteit.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by elena on 07/12/18.
 */

@Service
@Transactional
public class IngredientDetailsService implements IIngredientDetailsService {


    @Autowired
    private IIngredientDetailsDAO ingredientDetailsDAO;

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientDetailsDAO.getAllIngredients();
    }

    @Override
    public List<Dimension> getAllDimensions() {
        return ingredientDetailsDAO.getAllDimensions();
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        return ingredientDetailsDAO.getIngredientByName(name);
    }

    @Override
    public Dimension getDimensionByName(String name) {
        return ingredientDetailsDAO.getDimensionByName(name);
    }

    @Override
    public List<DishIngredientDetails> getIngredientsForDish(long dishId) {
        return ingredientDetailsDAO.getIngredientsForDish(dishId);
    }

    @Override
    public void saveIngredientDetails(DishIngredientDetails ingredientDetails) {
        ingredientDetailsDAO.saveIngredientDetails(ingredientDetails);
    }
}
