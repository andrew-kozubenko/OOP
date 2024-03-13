package org.example.pizza.menu;

import org.example.interfaces.CookingTime;

public class Neapolitan implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 13000;
    }
}