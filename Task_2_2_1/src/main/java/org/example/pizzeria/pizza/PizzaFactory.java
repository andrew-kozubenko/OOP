package org.example.pizzeria.pizza;

import org.example.pizzeria.pizza.menu.*;
import org.example.pizzeria.types.PizzaName;

/**
 * PizzaFactory.
 */
public class PizzaFactory{
    /**
     * getCookingTime.
     */
    public static Integer getCookingTime(PizzaName name) {
        return switch (name) {
            case MARGARET -> new Margaret().getCookingTime();
            case HAWAIIAN -> new Hawaiian().getCookingTime();
            case PEPPERONI -> new Pepperoni().getCookingTime();
            case NEAPOLITAN -> new Neapolitan().getCookingTime();
            case SICILIAN -> new Sicilian().getCookingTime();
            case SEASONS -> new Seasons().getCookingTime();
            case CAPRICCIOSA -> new Capricciosa().getCookingTime();
            case DIABOLA -> new Diabola().getCookingTime();
            case CARBONARA -> new Carbonara().getCookingTime();
            case FOUR_CHEESES -> new FourCheeses().getCookingTime();
            default -> throw new IllegalArgumentException("Недопустимое название пиццы: " + name);
        };
    }
}
