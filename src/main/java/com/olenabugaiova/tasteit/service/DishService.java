package com.olenabugaiova.tasteit.service;

import com.olenabugaiova.tasteit.dao.IDishDAO;
import com.olenabugaiova.tasteit.model.Dish;
import com.olenabugaiova.tasteit.model.DishCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by elena on 20/11/18.
 */

@Service
@Transactional
public class DishService implements IDishService {


    @Autowired
    private IDishDAO dishDAO;

    @Override
    public List<Dish> getDishes() {
        List<Dish> dishes = dishDAO.getAllDishes();
        return dishes;
    }

    @Override
    public List<Dish> getDishesByCategory(DishCategory category) {
        List<Dish> dishesByCategory = dishDAO.getDishesByCategory(category);
        return dishesByCategory;
    }

    @Override
    public Dish getDishById(long id) {
        Dish dish = dishDAO.getDishById(id);
        return dish;
    }

    @Override
    public synchronized boolean saveDish(Dish dish) {
        if (dishDAO.dishExists(dish.getName(), dish.getCategory())) {
            return false;
        } else {
            dishDAO.saveDish(dish);
            return true;
        }
    }

    @Override
    public boolean updateDish(Dish dish) {
        if (dishDAO.dishExists(dish.getName(), dish.getCategory())) {
            dishDAO.updateDish(dish);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteDish(long dishId) {
        dishDAO.deleteDish(dishId);
    }
}
