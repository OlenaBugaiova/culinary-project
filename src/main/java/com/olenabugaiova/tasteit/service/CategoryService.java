package com.olenabugaiova.tasteit.service;

import com.olenabugaiova.tasteit.dao.IDishCategoryDAO;
import com.olenabugaiova.tasteit.dao.IDishDAO;
import com.olenabugaiova.tasteit.model.DishCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by elena on 04/12/18.
 */

@Service
@Transactional
public class CategoryService implements ICategoryService {

    @Autowired
    private IDishCategoryDAO dishCategoryDAO;
    
    @Override
    public List<DishCategory> getAllCategories() {
        return dishCategoryDAO.getAllDishCategories();
    }

    @Override
    public DishCategory getCategoryById(long id) {
        return dishCategoryDAO.getDishCategoryById(id);
    }

    @Override
    public DishCategory getCategoryByName(String name) {
        return dishCategoryDAO.getDishCategoryByName(name);
    }

    @Override
    public void addCategory(DishCategory dishCategory) {
        dishCategoryDAO.saveDishCategory(dishCategory);
    }

    @Override
    public void deleteCategory(DishCategory category) {
        dishCategoryDAO.deleteDishCategory(category);
    }
}
