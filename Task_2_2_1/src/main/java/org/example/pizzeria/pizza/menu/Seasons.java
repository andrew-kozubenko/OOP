package org.example.pizzeria.pizza.menu;

import org.example.pizzeria.interfaces.CookingTime;

public class Seasons implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 11000;
    }
}