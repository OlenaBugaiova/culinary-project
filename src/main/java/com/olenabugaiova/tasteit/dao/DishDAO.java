package com.olenabugaiova.tasteit.dao;

import com.olenabugaiova.tasteit.model.Dish;
import com.olenabugaiova.tasteit.model.DishCategory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by elena on 21/11/18.
 */

@Repository
public class DishDAO implements IDishDAO {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Dish> getAllDishes() {
        String hqlQuery = "Select d FROM Dish d ORDER BY d.name";
        return (List<Dish>) entityManager.createQuery(hqlQuery).getResultList();
    }

    @Override
    public Dish getDishById(long dishId) {
        return entityManager.find(Dish.class, dishId);
    }

    @Override
    public List<Dish> getDishesByCategory(DishCategory category) {
        String hqlQuery = "Select d FROM Dish d WHERE d.category = ? ORDER BY d.name";
        List<Dish> dishesByCategory = (List<Dish>) entityManager.createQuery(hqlQuery)
                .setParameter(0, category)
                .getResultList();

        return dishesByCategory;
    }

    @Override
    public boolean dishExists(String name, DishCategory category) {
        String hql = "Select d FROM Dish d WHERE d.name = ? and d.category = ?";
        int count = entityManager.createQuery(hql)
                .setParameter(0, name)
                .setParameter(1, category)
                .getResultList()
                .size();

        return count > 0 ? true : false;
    }

    @Override
    public void saveDish(Dish dish) {
        entityManager.persist(dish);
    }

    @Override
    public void updateDish(Dish dish) {
        Dish currentDish = getDishById(dish.getId());
        currentDish.setName(dish.getName());
        currentDish.setCategory(dish.getCategory()); //  todo to check
        entityManager.flush();
    }

    @Override
    public void deleteDish(long id) {
        entityManager.remove(getDishById(id));
    }
}
