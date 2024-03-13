package org.example.pizzeria.orders;

import static org.junit.jupiter.api.Assertions.*;

import org.example.pizzeria.pizza.Pizza;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * OrdersGeneratorTest.
 */
public class OrdersGeneratorTest {
    private static final int MIN_ORDERS = 500;
    private static final int MAX_ORDERS = 1500;

    /**
     * testGenerateOrders.
     */
    @Test
    public void testGenerateOrders() {
        List<Order> orders = OrdersGenerator.generateOrders();
        assertNotNull(orders);
        assertFalse(orders.isEmpty());
        assertTrue(orders.size() >= MIN_ORDERS);
        assertTrue(orders.size() <= MAX_ORDERS);

        for (Order order : orders) {
            assertNotNull(order);
            assertNotNull(order.getName());
            assertNotNull(order.getAddress());
            assertFalse(order.getOrder().isEmpty());

            for (Pizza pizza : order.getOrder()) {
                assertNotNull(pizza);
                assertNotNull(pizza.getName());
            }
        }
    }
}
