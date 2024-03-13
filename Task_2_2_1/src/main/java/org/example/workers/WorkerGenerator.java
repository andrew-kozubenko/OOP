import org.example.blockingQueue.MyBlockingQueue;
import org.example.bakery.Baker;
import org.example.delivery.Courier;
import org.example.orders.Order;

import java.util.ArrayList;
import java.util.List;

public class WorkerGenerator {
    public static List<Baker> generateBakers(int numBakers,
                                             MyBlockingQueue<Order> orderQueue,
                                             MyBlockingQueue<Order> storageQueue) {
        List<Baker> bakers = new ArrayList<>();
        for (int i = 0; i < numBakers; i++) {
            Baker baker = new Baker("Baker-" + (i + 1), 100, orderQueue, storageQueue);
            bakers.add(baker);
        }
        return bakers;
    }

    public static List<Courier> generateCouriers(int numCouriers,
                                                 MyBlockingQueue<Order> storageQueue) {
        List<Courier> couriers = new ArrayList<>();
        for (int i = 0; i < numCouriers; i++) {
            Courier courier = new Courier("Courier-" + (i + 1), storageQueue);
            couriers.add(courier);
        }
        return couriers;
    }
}