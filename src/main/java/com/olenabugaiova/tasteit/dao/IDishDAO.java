package com.olenabugaiova.tasteit.dao;

import com.olenabugaiova.tasteit.model.Dish;
import com.olenabugaiova.tasteit.model.DishCategory;

import java.util.List;

/**
 * Created by elena on 21/11/18.
 */
public interface IDishDAO {

    public List<Dish> getAllDishes();

    public Dish getDishById(long id);

    public List<Dish> getDishesByCategory(DishCategory category);

    public boolean dishExists(String name, DishCategory category);

    public void saveDish(Dish dish);

    public void updateDish(Dish dish);

    public void deleteDish(long id);
}
