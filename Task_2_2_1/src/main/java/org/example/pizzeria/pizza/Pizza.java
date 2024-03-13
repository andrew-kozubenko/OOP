package org.example.pizzeria.pizza;

import org.example.pizzeria.types.PizzaName;

public class Pizza {
    private PizzaName name;

    public PizzaName getName() {
        return name;
    }

    public void setName(PizzaName name) {
        this.name = name;
    }

    public Pizza(PizzaName name) {
        this.name = name;
    }

    public Integer getCookingTime() {
        return PizzaFactory.getCookingTime(name);
    }
}
