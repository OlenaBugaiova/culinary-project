package com.olenabugaiova.tasteit.model;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by elena on 22/11/18.
 */

@Entity
@Table(name="dish_ingredient_details")
public class DishIngredientDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name="ingredient_id", nullable = false)
    private Ingredient ingredient;

    @NotNull
    @ManyToOne
    @JoinColumn(name="dimension_id", nullable = false)
    private Dimension dimension;

    @NotNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="dish_id", nullable = false)
    private Dish dish;

    @Column(name="amount")
    private float amount;

    @Column(name="comment",
            columnDefinition = "mediumtext")
    private String comment;

    public DishIngredientDetails() {
    }

    //  getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "DishIngredientDetails{" +
                "id=" + id +
                ", ingredient=" + ingredient +
                ", dimension=" + dimension +
                ", dish=" + dish +
                ", amount=" + amount +
                ", comment='" + comment + '\'' +
                '}';
    }
}
