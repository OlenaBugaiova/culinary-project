package com.olenabugaiova.tasteit.dto;

import com.olenabugaiova.tasteit.model.DishCategory;
import com.olenabugaiova.tasteit.model.DishIngredientDetails;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by elena on 14/12/18.
 */
public class DishDto implements Serializable {

    private static final long serialVersionUID = 7L;


    private long id;

    private String name;

    private MultipartFile image;

    private String howToServe;

    private String recipe;

    private String linkToWebsite;

    private String comment;

    private List<DishIngredientDetails> ingredients;

    private String category;


    public DishDto() {
    }

    //  getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getHowToServe() {
        return howToServe;
    }

    public void setHowToServe(String howToServe) {
        this.howToServe = howToServe;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getLinkToWebsite() {
        return linkToWebsite;
    }

    public void setLinkToWebsite(String linkToWebsite) {
        this.linkToWebsite = linkToWebsite;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<DishIngredientDetails> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<DishIngredientDetails> ingredients) {
        this.ingredients = ingredients;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
