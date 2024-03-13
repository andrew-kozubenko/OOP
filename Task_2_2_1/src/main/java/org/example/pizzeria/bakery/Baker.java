package org.example.pizzeria.bakery;

import org.example.pizzeria.Pizzeria;
import org.example.pizzeria.blockingQueue.MyBlockingQueue;
import org.example.pizzeria.orders.Order;
import org.example.pizzeria.pizza.Pizza;

public class Baker extends Thread {
    private String name;
    private Integer efficiencyPerc;
    private MyBlockingQueue<Order> orderQueue;
    private MyBlockingQueue<Order> storageQueue;
    private Pizzeria pizzeria;

    public Baker (String name, Integer efficiencyPerc,
                  MyBlockingQueue<Order> orderQueue,
                  MyBlockingQueue<Order> storageQueue,
                  Pizzeria pizzeria) {
        if (efficiencyPerc < 0 || efficiencyPerc > 100) {
            throw new IllegalArgumentException(
                    "Значение параметра efficiencyСoefficient" +
                            " должно лежать в диапазоне [0, 100]");
        }
        this.name = name;
        this.efficiencyPerc = efficiencyPerc;
        this.orderQueue = orderQueue;
        this.storageQueue = storageQueue;
        this.pizzeria = pizzeria;
    }

    public void cook() throws InterruptedException {
        Order order = orderQueue.take();
        Integer totalCookingTime = 0;
        for (Pizza pizza : order.getOrder()) {
            totalCookingTime += pizza.getCookingTime();
        }
        pizzeria.incrementBakers();
        System.out.println("Пекарь: " + name +
                " взял заказ от: " + order.getName());
        Thread.sleep((long) totalCookingTime * 100 / (long) efficiencyPerc);
        System.out.println("Пекарь: " + name +
                " говорит: \"Работа сделана!\" Заказ от: " + order.getName());
        toStorage(order);
        System.out.println("Пекарь: " + name +
                " положил на склад заказ от " + order.getName());
        pizzeria.decrementBakers();
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
