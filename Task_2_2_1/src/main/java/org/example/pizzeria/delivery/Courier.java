package org.example.pizzeria.delivery;

import org.example.pizzeria.Pizzeria;
import org.example.pizzeria.blockingQueue.MyBlockingQueue;
import org.example.pizzeria.orders.Order;

/**
 * Courier.
 */
public class Courier extends Thread{
    private String name;
    private Integer efficiencyPerc;
    private MyBlockingQueue<Order> storageQueue;
    private Pizzeria pizzeria;

    /**
     * Courier.
     */
    public Courier (String name, Integer efficiencyPerc,
                    MyBlockingQueue<Order> storageQueue,
                    Pizzeria pizzeria) {
        if (efficiencyPerc < 0 || efficiencyPerc > 100) {
            throw new IllegalArgumentException(
                    "Значение параметра efficiencyСoefficient" +
                            " должно лежать в диапазоне [0, 100]");
        }
        this.name = name;
        this.efficiencyPerc = efficiencyPerc;
        this.storageQueue = storageQueue;
        this.pizzeria = pizzeria;
    }

    /**
     * deliver.
     */
    public void deliver() throws InterruptedException {
        Order order = storageQueue.take();
        pizzeria.incrementCouriers();
        System.out.println("Курьер: " + name +
                " взял co склада заказ от: " + order.getName());
        Thread.sleep((long) 15000 * 100 / (long) efficiencyPerc);
        System.out.println("Курьер: " + name +
                " говорит: \"Работа сделана!\" Заказ от: " + order.getName() +
                " доставил на адрес: " + order.getAddress());
        pizzeria.decrementCouriers();
    }

    /**
     * run.
     */
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
