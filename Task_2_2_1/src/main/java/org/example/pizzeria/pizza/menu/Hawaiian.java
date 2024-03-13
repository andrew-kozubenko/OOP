package org.example.pizzeria.pizza.menu;

import org.example.pizzeria.interfaces.CookingTime;

public class Hawaiian implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 10000;
    }
}