package org.example.pizza;

import org.example.types.PizzaName;

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
