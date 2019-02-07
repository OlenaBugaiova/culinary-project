package com.olenabugaiova.tasteit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by elena on 19/11/18.
 */

@Entity
@Table(name="dishes")
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @NotNull
    @Column(name="name",
            nullable = false)
    private String name;

    @Column(name="image")
    private byte[] image;

    @Column(name="how_to_serve")
    private String howToServe;

    @Column(name="time_to_cook")
    private int timeToCookInMinutes;

    @NotNull
    @Column(name="recipe",
            nullable = false)
    private String recipe;

    @Column(name="link_to_website")
    private String linkToWebsite;

    @Column(name="comment")
    private String comment;

    @OneToMany(mappedBy="dish",
            cascade = {CascadeType.ALL},
            orphanRemoval = true)  //  todo to read about orphanRemoval
    private List<DishIngredientDetails> ingredients;

    @NotNull
    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private DishCategory category;

    public Dish() {
    }

    public void add(DishIngredientDetails ingredientDetails) {
        if(ingredients == null) {
            ingredients = new ArrayList<>();
        }
        ingredients.add(ingredientDetails);
        ingredientDetails.setDish(this);
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLinkToWebsite() {
        return linkToWebsite;
    }

    public void setLinkToWebsite(String linkToWebsite) {
        this.linkToWebsite = linkToWebsite;
    }

    public List<DishIngredientDetails> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<DishIngredientDetails> ingredients) {
        this.ingredients = ingredients;
    }

    public DishCategory getCategory() {
        return category;
    }

    public void setCategory(DishCategory category) {
        this.category = category;
    }

    public int getTimeToCookInMinutes() {
        return timeToCookInMinutes;
    }

    public void setTimeToCookInMinutes(int timeToCookInMinutes) {
        this.timeToCookInMinutes = timeToCookInMinutes;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                ", howToServe='" + howToServe + '\'' +
                ", recipe='" + recipe + '\'' +
                ", timeToCookInMinutes='" + timeToCookInMinutes + '\'' +
                ", linkToWebsite='" + linkToWebsite + '\'' +
                ", comment='" + comment + '\'' +
                ", ingredients=" + ingredients.size() +
                ", category=" + category +
                '}';
    }
}
