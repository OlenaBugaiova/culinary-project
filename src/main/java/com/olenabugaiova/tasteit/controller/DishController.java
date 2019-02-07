package com.olenabugaiova.tasteit.controller;

import com.olenabugaiova.tasteit.dto.DishDto;
import com.olenabugaiova.tasteit.model.*;
import com.olenabugaiova.tasteit.service.ICategoryService;
import com.olenabugaiova.tasteit.service.IDishService;
import com.olenabugaiova.tasteit.service.IIngredientDetailsService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Base64;
import org.slf4j.Logger;

/**
 * Created by elena on 18/11/18.
 */

@Controller
@RequestMapping("/dish")
public class DishController {

    private static final Logger logger = LoggerFactory.getLogger(DishController.class.getName());

    public static final String VIEW_ALL_DISHES = "View All";

    @Autowired
    private IDishService dishService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IIngredientDetailsService ingredientDetailsService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/new")
    public String displayDishForm(Model dishModel) {

        dishModel.addAttribute("dish", new DishDto());
        dishModel.addAttribute("categories", categoryService.getAllCategories());
        return "forms/dish-form";
    }

    @PostMapping("/new")
    public String saveDish(Model dishModel, @ModelAttribute DishDto dishDto, final BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "redirect:/dish/forms/dish-form";
        }

        Dish dish = null;
        try {
            dish = convertToEntity(dishDto);
            DishCategory dishCategory = categoryService.getCategoryByName(dishDto.getCategory());
            dish.setCategory(dishCategory);
            dishService.saveDish(dish);
        } catch (ParseException e) {
            logger.error("Parse exception occurred during parsing of dish " + dish.getName());
        } catch (IOException e) {
            logger.error("IOException occurred during parsing of dish " + dish.getName());
        }

        dishDto.setId(dish.getId());
        String imageView = Base64.getEncoder().encodeToString(dish.getImage());
        dishModel.addAttribute("dish", dishDto);
        dishModel.addAttribute("image", imageView);

        return "forms/dish-form-2";
    }

    @GetMapping("/showdishes/{category}")
    public String getDishes(@PathVariable String category, Model model) {
        DishCategory dishCategory = categoryService.getCategoryByName(category);
        model.addAttribute("dishes", dishService.getDishesByCategory(dishCategory));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("selectedCategory", category);
        return "view/list-of-dishes";
    }


    @GetMapping("/showdishes")
    public String getDishes(Model model) {
        model.addAttribute("dishes", dishService.getDishes());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("selectedCategory", VIEW_ALL_DISHES);
        return "view/list-of-dishes";
    }

    @DeleteMapping("{id}/delete")
    public String deleteDish(@PathVariable long id) {
        dishService.deleteDish(id);
        return "redirect:/dish/showdishes";
    }

    private DishDto convertToDto(Dish dish) {
        DishDto dishDto = modelMapper.map(dish, DishDto.class);
        return dishDto;
    }

    private Dish convertToEntity(DishDto dishDto) throws ParseException, IOException {
        Dish dish = modelMapper.map(dishDto, Dish.class);
        dish.setImage(dishDto.getImage().getBytes());
        dish.setTimeToCookInMinutes(Integer.parseInt(dishDto.getTimeToCookInMinutes()));
        return dish;
    }

}
