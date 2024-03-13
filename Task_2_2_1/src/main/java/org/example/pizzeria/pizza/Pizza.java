package org.example.pizzeria.pizza;

import org.example.pizzeria.types.PizzaName;

/**
 * Pizza.
 */
public class Pizza {
    private PizzaName name;

    public PizzaName getName() {
        return name;
    }

    /**
     * setName.
     */
    public void setName(PizzaName name) {
        this.name = name;
    }

    /**
     * Pizza.
     */
    public Pizza(PizzaName name) {
        this.name = name;
    }

    /**
     * getCookingTime.
     */
    public Integer getCookingTime() {
        return PizzaFactory.getCookingTime(name);
    }
}
