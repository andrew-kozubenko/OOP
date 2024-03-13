package org.example.pizzeria.orders;

import org.example.pizzeria.blockingQueue.MyBlockingQueue;
import java.util.List;

/**
 * OrderAcceptance.
 */
public class OrderAcceptance extends Thread{
    private MyBlockingQueue<Order> orderQueue;
    private List<Order> orderList;

    /**
     * OrderAcceptance.
     */
    public OrderAcceptance (MyBlockingQueue<Order> orderQueue,
                            List<Order> orderList) {
        this.orderQueue = orderQueue;
        this.orderList = orderList;
    }

    /**
     * run.
     */
    @Override
    public void run() {
        for (Order order : orderList) {
            try {
                Thread.sleep(2000);
                orderQueue.put(order);
                System.out.println("Принят заказ: " + order.getName());
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
