package com.olenabugaiova.tasteit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Created by elena on 08/11/18.
 */


@Controller
public class HomePageController {

    @GetMapping("/home")
    public String getHomePage() {
        return "welcome";
    }
}
