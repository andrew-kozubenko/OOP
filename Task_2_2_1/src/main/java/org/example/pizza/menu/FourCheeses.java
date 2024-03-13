package org.example.pizza.menu;

import org.example.interfaces.CookingTime;

public class FourCheeses implements CookingTime {
    @Override
    public Integer getCookingTime() {
        return 7000;
    }
}