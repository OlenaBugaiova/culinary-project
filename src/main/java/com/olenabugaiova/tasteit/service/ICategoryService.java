package com.olenabugaiova.tasteit.service;


import com.olenabugaiova.tasteit.model.DishCategory;

import java.util.List;

/**
 * Created by elena on 04/12/18.
 */
public interface ICategoryService {

    public List<DishCategory> getAllCategories();

    public DishCategory getCategoryById(long id);

    public DishCategory getCategoryByName(String name);

    public void addCategory(DishCategory dishCategory);

    public void deleteCategory(DishCategory category);
}
