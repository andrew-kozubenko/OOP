package org.example.pizzeria.pizza.menu;

import org.example.pizzeria.interfaces.CookingTime;

/**
 * Diabola.
 */
public class Diabola implements CookingTime {
    /**
     * getCookingTime.
     */
    @Override
    public Integer getCookingTime() {
        return 12000;
    }
}