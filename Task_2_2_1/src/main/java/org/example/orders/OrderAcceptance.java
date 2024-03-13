package org.example.orders;

import org.example.blockingQueue.MyBlockingQueue;
import org.example.pizza.Pizza;

import java.util.List;

public class OrderAcceptance extends Thread{
    private MyBlockingQueue<Order> orderQueue;
    private List<Order> orderList;

    public OrderAcceptance (MyBlockingQueue<Order> orderQueue,
                            List<Order> orderList) {
        this.orderQueue = orderQueue;
        this.orderList = orderList;
    }

    @Override
    public void run() {
        for (Order order : orderList) {
            try {
                Thread.sleep(3000);
                orderQueue.put(order);
                System.out.println("Принят заказ: " + order.getName());
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
