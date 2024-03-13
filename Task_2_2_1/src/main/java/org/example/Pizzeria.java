package org.example;

import org.example.bakery.Baker;
import org.example.blockingQueue.MyBlockingQueue;
import org.example.delivery.Courier;
import org.example.orders.Order;
import org.example.orders.OrderAcceptance;
import org.example.orders.OrdersGenerator;
import org.example.workers.WorkerGenerator;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Pizzeria {
    private AtomicInteger activeBakers;
    private AtomicInteger activeCouriers;
    private MyBlockingQueue<Order> ordersQueue;
    private MyBlockingQueue<Order> storageQueue;

    public Pizzeria (Integer maxOrders, Integer maxStorage) {
        this.ordersQueue = new MyBlockingQueue<Order>(maxOrders);
        this.storageQueue = new MyBlockingQueue<Order>(maxStorage);
    }
    public void startWorkingDay() {
        activeBakers = new AtomicInteger(0);
        activeCouriers = new AtomicInteger(0);

        List<Order> orderList = OrdersGenerator.generateOrders();
        OrderAcceptance orderAcceptanceThread = new OrderAcceptance(ordersQueue, orderList);
        orderAcceptanceThread.start();

        // Генерация и запуск пекарей
        List<Baker> bakers = WorkerGenerator.generateBakers(
                10, ordersQueue, storageQueue, this);
        for (Baker baker : bakers) {
            baker.start();
        }

        // Генерация и запуск курьеров
        List<Courier> couriers = WorkerGenerator.generateCouriers(
                30, storageQueue, this);
        for (Courier courier : couriers) {
            courier.start();
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Останавливаем поток приема заказов
                orderAcceptanceThread.interrupt();
            }
        }, 30 * 1000); //1 минута

        // Дожидаемся завершения работы пиццерии
        try {
            orderAcceptanceThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ожидаем, пока все заказы не будут обработаны
        while (!ordersQueue.isEmpty() || activeBakers.get() > 0) {
            try {
                System.out.println("Ждем пекарей... Очередь заказов " +
                        (ordersQueue.isEmpty() ? "пуста" : "имеется") +
                        ". Пекарей работает: " + activeBakers.get());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Останавливаем потоки пекарей
        for (Baker baker : bakers) {
            baker.interrupt();
        }

        // Ожидаем, пока все пиццы не будут развезены
        while (!storageQueue.isEmpty() || activeCouriers.get() > 0) {
            try {
                System.out.println("Ждем курьеров... Склад " +
                        (storageQueue.isEmpty() ? "пуст" : "не пуст") +
                        ". Курьеров работает: " + activeCouriers.get());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Останавливаем потоки курьеров
        for (Courier courier : couriers) {
            courier.interrupt();
        }

        // Завершаем работу пиццерии
        timer.cancel();
        System.out.println("Пиццерия закрыта.");
    }

    public void incrementBakers() {
        activeBakers.incrementAndGet();
    }

    public void decrementBakers() {
        activeBakers.decrementAndGet();
    }

    public void incrementCouriers() {
        activeCouriers.incrementAndGet();
    }

    public void decrementCouriers() {
        activeCouriers.decrementAndGet();
    }
}
