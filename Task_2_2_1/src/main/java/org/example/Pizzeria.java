package org.example;

import org.example.blockingQueue.MyBlockingQueue;
import org.example.orders.Order;
import org.example.orders.OrderAcceptance;
import org.example.orders.OrdersGenerator;
import org.example.pizza.Pizza;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Pizzeria {
    private MyBlockingQueue<Order> ordersQueue;
    private MyBlockingQueue<Order> storageQueue;

    public Pizzeria (Integer maxOrders, Integer maxStorage) {
        this.ordersQueue = new MyBlockingQueue<Order>(maxOrders);
        this.storageQueue = new MyBlockingQueue<Order>(maxStorage);
    }
    public void startWorkingDay() {
        List<Order> orderList = OrdersGenerator.generateOrders();
        OrderAcceptance orderAcceptanceThread = new OrderAcceptance(ordersQueue, orderList);
        orderAcceptanceThread.start();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Останавливаем поток приема заказов
                orderAcceptanceThread.interrupt();
            }
        }, 8 * 60 * 1000); // 8 минут

        // Дожидаемся завершения потока приема заказов
        try {
            orderAcceptanceThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Завершаем работу пиццерии
        timer.cancel();
        System.out.println("Пиццерия закрыта.");
    }
}
