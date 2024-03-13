package org.example.pizzeria.types;

import java.util.Random;

public enum PizzaName {
    MARGARET,
    HAWAIIAN,
    PEPPERONI,
    NEAPOLITAN,
    SICILIAN,
    SEASONS,
    CAPRICCIOSA,
    DIABOLA,
    CARBONARA,
    FOUR_CHEESES;

    private static final PizzaName[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static PizzaName getRandomPizzaName() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
