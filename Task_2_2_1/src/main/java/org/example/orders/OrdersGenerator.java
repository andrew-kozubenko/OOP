package org.example.orders;

import org.example.pizza.Pizza;
import org.example.types.PizzaName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrdersGenerator {
    private static final int MIN_ORDERS = 500;
    private static final int MAX_ORDERS = 1500;
    private static final int MIN_PIZZAS_PER_ORDER = 1;
    private static final int MAX_PIZZAS_PER_ORDER = 3;

    private static int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static List<Order> generateOrders() {
        List<Order> orders = new ArrayList<>();
        int numberOfOrders = getRandomNumberInRange(MIN_ORDERS, MAX_ORDERS);
        for (int i = 0; i < numberOfOrders; i++) {
            String name = "Customer" + i;
            String address = "Address" + i;
            List<Pizza> pizzas = generateRandomPizzas();
            Order order = new Order(name, address, pizzas);
            orders.add(order);
        }
        return orders;
    }

    private static List<Pizza> generateRandomPizzas() {
        List<Pizza> pizzas = new ArrayList<>();
        int numberOfPizzas = getRandomNumberInRange(MIN_PIZZAS_PER_ORDER, MAX_PIZZAS_PER_ORDER);
        for (int i = 0; i < numberOfPizzas; i++) {
            PizzaName randomPizzaName = PizzaName.getRandomPizzaName();
            Pizza pizza = new Pizza(randomPizzaName);
            pizzas.add(pizza);
        }
        return pizzas;
    }
}
