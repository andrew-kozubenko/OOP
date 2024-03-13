package org.example.delivery;

import org.example.blockingQueue.MyBlockingQueue;
import org.example.orders.Order;
import org.example.pizza.Pizza;

public class Courier extends Thread{
    private String name;
    private Integer efficiencyPerc;
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
        this.storageQueue = storageQueue;
    }

    private void deliver() throws InterruptedException {
        Order order = storageQueue.take();
        Thread.sleep((long) 30000 * (long) efficiencyPerc / 100);
        System.out.println("Курьер: " + name +
                " говорит: \"Работа сделана!\" Заказ от: " + order.getName() +
                " доставил на адрес: " + order.getAddress());
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
