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
        switch (name) {
            case MARGARET:
                return new Margaret().getCookingTime();
            case HAWAIIAN:
                return new Hawaiian().getCookingTime();
            case PEPPERONI:
                return new Pepperoni().getCookingTime();
            case NEAPOLITAN:
                return new Neapolitan().getCookingTime();
            case SICILIAN:
                return new Sicilian().getCookingTime();
            case SEASONS:
                return new Seasons().getCookingTime();
            case CAPRICCIOSA:
                return new Capricciosa().getCookingTime();
            case DIABOLA:
                return new Diabola().getCookingTime();
            case CARBONARA:
                return new Carbonara().getCookingTime();
            case FOUR_CHEESES:
                return new FourCheeses().getCookingTime();
            default:
                throw new IllegalArgumentException("Недопустимое название пиццы: " + name);
        }
    }

}
