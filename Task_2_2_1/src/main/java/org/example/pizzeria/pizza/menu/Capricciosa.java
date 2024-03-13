package org.example.pizzeria.pizza.menu;

import org.example.pizzeria.interfaces.CookingTime;

/**
 * Capricciosa.
 */
public class Capricciosa implements CookingTime {
    /**
     * getCookingTime.
     */
    @Override
    public Integer getCookingTime() {
        return 11000;
    }
}
