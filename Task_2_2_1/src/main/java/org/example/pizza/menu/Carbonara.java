package org.example.pizza.menu;

import org.example.interfaces.CookingTime;

public class Carbonara implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 8000;
    }
}