package com.olenabugaiova.tasteit;

import com.olenabugaiova.tasteit.formatter.DimensionFormatter;
import com.olenabugaiova.tasteit.formatter.IngredientFormatter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by elena on 08/11/18.
 */

@SpringBootApplication
public class TasteItBootApplication{

    public static void main(String[] args) {
        SpringApplication.run(TasteItBootApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Configuration
    static class MyConfig implements WebMvcConfigurer {

        @Autowired
        private IngredientFormatter ingredientFormatter;

        @Autowired
        DimensionFormatter dimensionFormatter;

        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addFormatter(ingredientFormatter);
            registry.addFormatter(dimensionFormatter);
        }
    }
}
