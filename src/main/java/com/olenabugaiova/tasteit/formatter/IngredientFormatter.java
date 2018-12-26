package com.olenabugaiova.tasteit.formatter;

import com.olenabugaiova.tasteit.model.Ingredient;
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
public class IngredientFormatter implements Formatter<Ingredient> {

    @Autowired
    IIngredientDetailsService ingredientDetailsService;

    @Override
    public Ingredient parse(String text, Locale locale) throws ParseException {
        return ingredientDetailsService.getIngredientByName(text);
    }

    @Override
    public String print(Ingredient object, Locale locale) {
        return (object != null ? object.getName() : "");
    }
}
