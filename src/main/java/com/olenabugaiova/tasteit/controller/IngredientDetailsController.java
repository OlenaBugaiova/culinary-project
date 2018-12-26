package com.olenabugaiova.tasteit.controller;

import com.olenabugaiova.tasteit.model.Dimension;
import com.olenabugaiova.tasteit.model.DishIngredientDetails;
import com.olenabugaiova.tasteit.model.Ingredient;
import com.olenabugaiova.tasteit.service.IDishService;
import com.olenabugaiova.tasteit.service.IIngredientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by elena on 18/11/18.
 */


@Controller
public class IngredientDetailsController {

    @Autowired
    private IIngredientDetailsService ingredientDetailsService;

    @Autowired
    private IDishService dishService;

    private List<Ingredient> allIngredients;  //   todo to add cache https://github.com/google/guava/wiki/CachesExplained
    private List<Dimension> allDimensions;    //   todo https://stackoverflow.com/questions/575685/looking-for-simple-java-in-memory-cache

    @GetMapping("dish/{dishId}/add-ingredient")
    public String getIngredientForm(@PathVariable long dishId,
                                    Model ingredientModel) {

        addDataToIngredientModel(ingredientModel, dishId);
        return "forms/ingredient-form";
    }

    @PostMapping("dish/{dishId}/add-ingredient")
    public String addIngredientToDish(@PathVariable long dishId,
                                      @ModelAttribute DishIngredientDetails ingredientDetails,
                                      final BindingResult bindingResult,
                                      Model ingredientModel) {

        if(bindingResult.hasErrors()){
            return "welcome";  //   todo to add redirect
        }

        ingredientDetails.setDish(dishService.getDishById(dishId));
        ingredientDetailsService.saveIngredientDetails(ingredientDetails);

        addDataToIngredientModel(ingredientModel, dishId);
        return "forms/ingredient-form";
    }

    private void addDataToIngredientModel(Model ingredientModel, long dishId) {
        List<DishIngredientDetails> dishIngredients = ingredientDetailsService.getIngredientsForDish(dishId);

        ingredientModel.addAttribute("dishId", dishId);
        ingredientModel.addAttribute("dishIngredients", dishIngredients);
        ingredientModel.addAttribute("ingredientDetails", new DishIngredientDetails());
        ingredientModel.addAttribute("ingredients", getAllIngredients());
        ingredientModel.addAttribute("dimensions", getAllDimensions());
    }

    private List<Ingredient> getAllIngredients() {
        if(Optional.ofNullable(allIngredients).isPresent()) {
            return allIngredients;
        }
        allIngredients = Collections.synchronizedList(ingredientDetailsService.getAllIngredients());
        return allIngredients;
    }

    private List<Dimension> getAllDimensions() {
        if(Optional.ofNullable(allDimensions).isPresent()) {
            return allDimensions;
        }
        allDimensions = Collections.synchronizedList(ingredientDetailsService.getAllDimensions());
        return allDimensions;
    }
}
