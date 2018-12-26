package com.olenabugaiova.tasteit.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by elena on 19/11/18.
 */

@Entity
@Table(name="ingredients")
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @NotNull
    @Column(name="name", unique = true, nullable = false)
    private String name;

    @Column(name="description")
    private String description;

//    private float calories;  todo

    public Ingredient() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
