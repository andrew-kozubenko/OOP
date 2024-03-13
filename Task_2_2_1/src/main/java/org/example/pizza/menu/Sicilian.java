package org.example.pizza.menu;

import org.example.interfaces.CookingTime;

public class Sicilian implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 15000;
    }
}