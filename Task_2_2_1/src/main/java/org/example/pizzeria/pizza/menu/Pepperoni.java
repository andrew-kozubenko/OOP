package org.example.pizzeria.pizza.menu;

import org.example.pizzeria.interfaces.CookingTime;

/**
 * Pepperoni.
 */
public class Pepperoni implements CookingTime {
    /**
     * getCookingTime.
     */
    @Override
    public Integer getCookingTime() {
        return 9000;
    }
}