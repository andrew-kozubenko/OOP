package org.example.pizzeria.pizza.menu;

import org.example.pizzeria.interfaces.CookingTime;

/**
 * Hawaiian.
 */
public class Hawaiian implements CookingTime {
    /**
     * getCookingTime.
     */
    @Override
    public Integer getCookingTime() {
        return 10000;
    }
}