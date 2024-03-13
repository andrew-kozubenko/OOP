package org.example.pizzeria.orders;

import org.example.pizzeria.pizza.Pizza;

import java.util.List;

public class Order {
    private String name;
    private String address;
    private List<Pizza> order;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Pizza> getOrder() {
        return order;
    }

    public Order(String name, String address, List<Pizza> order) {
        this.name = name;
        this.address = address;
        this.order = order;
    }
}
