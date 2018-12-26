package com.olenabugaiova.tasteit.dao;

import com.olenabugaiova.tasteit.model.DishCategory;

import java.util.List;

/**
 * Created by elena on 04/12/18.
 */
public interface IDishCategoryDAO {

    public List<DishCategory> getAllDishCategories();

    public DishCategory getDishCategoryById(long id);

    public DishCategory getDishCategoryByName(String name);

    public void saveDishCategory(DishCategory dish);

    public void deleteDishCategory(DishCategory dish);

    public boolean dishCategoryExists(String categoryName);
}
