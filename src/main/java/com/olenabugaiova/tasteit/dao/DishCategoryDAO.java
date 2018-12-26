package com.olenabugaiova.tasteit.dao;

import com.olenabugaiova.tasteit.model.Dish;
import com.olenabugaiova.tasteit.model.DishCategory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by elena on 04/12/18.
 */

@Repository
public class DishCategoryDAO implements IDishCategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DishCategory> getAllDishCategories() {
        String hqlQuery = "Select dc FROM DishCategory dc ORDER BY dc.categoryName";
        return (List<DishCategory>) entityManager.createQuery(hqlQuery).getResultList();
    }

    @Override
    public DishCategory getDishCategoryById(long dishId) {
        return entityManager.find(DishCategory.class, dishId);
    }

    @Override
    public DishCategory getDishCategoryByName(String categoryName) {
        List<DishCategory> dishCategories = getDishCategoriesByName(categoryName);
        return dishCategories.size() == 1 ? dishCategories.get(0) : null;
    }

    @Override
    public boolean dishCategoryExists(String categoryName) {
        int count = getDishCategoriesByName(categoryName).size();
        return count > 0 ? true : false;
    }

    @Override
    public void saveDishCategory(DishCategory category) {
        entityManager.persist(category);
    }

    @Override
    public void deleteDishCategory(DishCategory category) {
        entityManager.remove(category);
    }

    private List<DishCategory> getDishCategoriesByName(String categoryName) {
        String hql = "Select dc FROM DishCategory dc WHERE dc.categoryName = ?";
        return entityManager.createQuery(hql).setParameter(0, categoryName).getResultList();
    }
}
