package org.example.bakery;

import org.example.blockingQueue.MyBlockingQueue;
import org.example.orders.Order;
import org.example.pizza.Pizza;

import java.util.List;

public class Baker extends Thread {
    private String name;
    private Integer efficiencyPerc;
    private MyBlockingQueue<Order> orderQueue;
    private MyBlockingQueue<Order> storageQueue;

    public void Baker (String name, Integer efficiencyPerc,
                       MyBlockingQueue<Order> orderQueue,
                       MyBlockingQueue<Order> storageQueue) {
        if (efficiencyPerc < 0 || efficiencyPerc > 100) {
            throw new IllegalArgumentException(
                    "Значение параметра efficiencyСoefficient" +
                            " должно лежать в диапазоне [0.0, 1.0]");
        }
        this.name = name;
        this.efficiencyPerc = efficiencyPerc;
        this.orderQueue = orderQueue;
        this.storageQueue = storageQueue;
    }

    private void cook() throws InterruptedException {
        Order order = orderQueue.take();
        Integer totalCookingTime = 0;
        for (Pizza pizza : order.getOrder()) {
            totalCookingTime += pizza.getCookingTime();
        }
        Thread.sleep((long) totalCookingTime * (long) efficiencyPerc / 100);
        System.out.println("Пекарь: " + name +
                " говорит: \"Работа сделана!\" Заказ от: " + order.getName());
        toStorage(order);
        System.out.println("Пекарь: " + name +
                " положил на склад заказ от " + order.getName());
    }

    private void toStorage(Order order) throws InterruptedException {
        storageQueue.put(order);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                cook();
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
