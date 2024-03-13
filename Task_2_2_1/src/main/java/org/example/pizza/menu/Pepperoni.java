package org.example.pizza.menu;

import org.example.interfaces.CookingTime;

public class Pepperoni implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 9000;
    }
}