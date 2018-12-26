package com.olenabugaiova.tasteit.formatter;

import com.olenabugaiova.tasteit.model.Dimension;
import com.olenabugaiova.tasteit.service.IIngredientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by elena on 24/12/18.
 */

@Service
public class DimensionFormatter implements Formatter<Dimension> {

    @Autowired
    IIngredientDetailsService ingredientDetailsService;

    @Override
    public Dimension parse(String text, Locale locale) throws ParseException {
        return ingredientDetailsService.getDimensionByName(text);
    }

    @Override
    public String print(Dimension object, Locale locale) {
        return (object != null ? object.getName() : "");
    }
}
