package com.olenabugaiova.tasteit.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by elena on 21/11/18.
 */

@Entity
@Table(name="dimensions")
public class Dimension implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @NotNull
    @Column(name="name", unique = true, nullable = false)
    private String name;

    @Column(name="is_standard")
    private boolean isStandard;

    @Column(name="coefficient")
    private float coefficient;


    //  todo conversion


    public Dimension() {

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

    public boolean isStandard() {
        return isStandard;
    }

    public void setStandard(boolean isStandard) {
        this.isStandard = isStandard;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }
}
