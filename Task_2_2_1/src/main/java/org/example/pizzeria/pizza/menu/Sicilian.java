package org.example.pizzeria.pizza.menu;

import org.example.pizzeria.interfaces.CookingTime;

public class Sicilian implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 15000;
    }
}