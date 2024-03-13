package org.example.workers;

import org.example.Pizzeria;
import org.example.blockingQueue.MyBlockingQueue;
import org.example.bakery.Baker;
import org.example.delivery.Courier;
import org.example.orders.Order;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class WorkerGenerator {
    private static final int MIN_PERC = 80;
    private static final int MAX_PERC = 100;

    private static int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    public static List<Baker> generateBakers(int numBakers,
                                             MyBlockingQueue<Order> orderQueue,
                                             MyBlockingQueue<Order> storageQueue,
                                             Pizzeria pizzeria) {
        List<Baker> bakers = new ArrayList<>();
        for (int i = 0; i < numBakers; i++) {
            Baker baker = new Baker("Baker-" + (i + 1),
                    getRandomNumberInRange(MIN_PERC, MAX_PERC),
                    orderQueue, storageQueue, pizzeria);
            bakers.add(baker);
        }
        return bakers;
    }

    public static List<Courier> generateCouriers(int numCouriers,
                                                 MyBlockingQueue<Order> storageQueue,
                                                 Pizzeria pizzeria) {
        List<Courier> couriers = new ArrayList<>();
        for (int i = 0; i < numCouriers; i++) {
            Courier courier = new Courier("Courier-" + (i + 1),
                    getRandomNumberInRange(MIN_PERC, MAX_PERC),
                    storageQueue, pizzeria);
            couriers.add(courier);
        }
        return couriers;
    }
}