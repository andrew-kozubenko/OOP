package org.example.pizzeria.pizza.menu;

import org.example.pizzeria.interfaces.CookingTime;

public class Carbonara implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 8000;
    }
}