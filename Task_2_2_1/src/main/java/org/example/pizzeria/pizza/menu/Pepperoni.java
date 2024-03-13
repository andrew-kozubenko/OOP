package org.example.pizzeria.pizza.menu;

import org.example.pizzeria.interfaces.CookingTime;

public class Pepperoni implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 9000;
    }
}