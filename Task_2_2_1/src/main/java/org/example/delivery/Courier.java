package org.example.delivery;

import org.example.Pizzeria;
import org.example.blockingQueue.MyBlockingQueue;
import org.example.orders.Order;
import org.example.pizza.Pizza;

import java.util.concurrent.atomic.AtomicInteger;

public class Courier extends Thread{
    private String name;
    private Integer efficiencyPerc;
    private MyBlockingQueue<Order> storageQueue;
    private Pizzeria pizzeria;

    public Courier (String name, Integer efficiencyPerc,
                    MyBlockingQueue<Order> storageQueue,
                    Pizzeria pizzeria) {
        if (efficiencyPerc < 0 || efficiencyPerc > 100) {
            throw new IllegalArgumentException(
                    "Значение параметра efficiencyСoefficient" +
                            " должно лежать в диапазоне [0.0, 1.0]");
        }
        this.name = name;
        this.efficiencyPerc = efficiencyPerc;
        this.storageQueue = storageQueue;
        this.pizzeria = pizzeria;
    }

    private void deliver() throws InterruptedException {
        Order order = storageQueue.take();
        pizzeria.incrementCouriers();
        System.out.println("Курьер: " + name +
                " взял заказ от: " + order.getName());
        Thread.sleep((long) 15000 * 100 / (long) efficiencyPerc);
        System.out.println("Курьер: " + name +
                " говорит: \"Работа сделана!\" Заказ от: " + order.getName() +
                " доставил на адрес: " + order.getAddress());
        pizzeria.decrementCouriers();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                deliver();
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
