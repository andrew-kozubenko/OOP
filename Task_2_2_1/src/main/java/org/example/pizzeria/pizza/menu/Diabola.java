package org.example.pizzeria.pizza.menu;

import org.example.pizzeria.interfaces.CookingTime;

public class Diabola implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 12000;
    }
}