package com.olenabugaiova.tasteit.dao;

import com.olenabugaiova.tasteit.model.Dimension;
import com.olenabugaiova.tasteit.model.DishIngredientDetails;
import com.olenabugaiova.tasteit.model.Ingredient;

import java.util.List;

/**
 * Created by elena on 07/12/18.
 */
public interface IIngredientDetailsDAO {

    public List<Ingredient> getAllIngredients();

    public List<Dimension> getAllDimensions();

    public Ingredient getIngredientByName(String name);

    public Ingredient getIngredientById(long id);

    public Dimension getDimensionByName(String name);

    public Dimension getDimensionById(long id);

    public void saveIngredientDetails(DishIngredientDetails dishIngredientDetails);

    List<DishIngredientDetails> getIngredientsForDish(long dishId);
}
