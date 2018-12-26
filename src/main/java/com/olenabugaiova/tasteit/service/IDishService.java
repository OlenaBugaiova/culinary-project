package com.olenabugaiova.tasteit.service;

import com.olenabugaiova.tasteit.model.Dish;
import com.olenabugaiova.tasteit.model.DishCategory;

import java.util.List;

/**
 * Created by elena on 20/11/18.
 */
public interface IDishService {

    public List<Dish> getDishes();

    public List<Dish> getDishesByCategory(DishCategory category);

    public Dish getDishById(long id);

    public boolean saveDish(Dish dish);

    public boolean updateDish(Dish dish);

    public void deleteDish(long dishId);
}
