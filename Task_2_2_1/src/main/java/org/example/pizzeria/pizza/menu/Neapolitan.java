package org.example.pizzeria.pizza.menu;

import org.example.pizzeria.interfaces.CookingTime;

public class Neapolitan implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 13000;
    }
}