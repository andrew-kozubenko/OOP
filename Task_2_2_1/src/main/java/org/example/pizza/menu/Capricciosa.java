package org.example.pizza.menu;

import org.example.interfaces.CookingTime;

public class Capricciosa implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 11000;
    }
}
