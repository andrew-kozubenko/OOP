package org.example.pizzeria.pizza.menu;

import org.example.pizzeria.interfaces.CookingTime;

/**
 * Carbonara.
 */
public class Carbonara implements CookingTime {
    /**
     * getCookingTime.
     */
    @Override
    public Integer getCookingTime() {
        return 8000;
    }
}