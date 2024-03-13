package org.example.pizzeria.orders;

import org.example.pizzeria.pizza.Pizza;
import java.util.List;

/**
 * Order.
 */
public class Order {
    private String name;
    private String address;
    private List<Pizza> order;

    /**
     * getName.
     */
    public String getName() {
        return name;
    }

    /**
     * getAddress.
     */
    public String getAddress() {
        return address;
    }

    /**
     * getOrder.
     */
    public List<Pizza> getOrder() {
        return order;
    }

    /**
     * Order.
     */
    public Order(String name, String address, List<Pizza> order) {
        this.name = name;
        this.address = address;
        this.order = order;
    }
}
