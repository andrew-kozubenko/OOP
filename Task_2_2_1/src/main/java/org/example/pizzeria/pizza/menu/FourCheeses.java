package org.example.pizzeria.pizza.menu;

import org.example.pizzeria.interfaces.CookingTime;

public class FourCheeses implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 7000;
    }
}