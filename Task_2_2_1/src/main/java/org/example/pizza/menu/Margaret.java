package org.example.pizza.menu;

import org.example.interfaces.CookingTime;

public class Margaret implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 10000;
    }
}