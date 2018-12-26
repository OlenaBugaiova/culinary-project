package com.olenabugaiova.tasteit.service;

import com.olenabugaiova.tasteit.model.Dimension;
import com.olenabugaiova.tasteit.model.DishIngredientDetails;
import com.olenabugaiova.tasteit.model.Ingredient;

import java.util.List;

/**
 * Created by elena on 07/12/18.
 */
public interface IIngredientDetailsService {

    public List<Ingredient> getAllIngredients();

    public List<Dimension> getAllDimensions();

    public Ingredient getIngredientByName(String name);

    public Dimension getDimensionByName(String name);

    public List<DishIngredientDetails> getIngredientsForDish(long dishId);

    public void saveIngredientDetails(DishIngredientDetails ingredientDetails);
}
