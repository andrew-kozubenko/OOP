package org.example.pizzeria.workers;

import org.example.pizzeria.Pizzeria;
import org.example.pizzeria.blockingQueue.MyBlockingQueue;
import org.example.pizzeria.bakery.Baker;
import org.example.pizzeria.delivery.Courier;
import org.example.pizzeria.orders.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class WorkerGeneratorTest {

    @Test
    public void testGenerateBakers() {
        // Создаем моки очередей и пиццерии
        MyBlockingQueue<Order> mockOrderQueue = mock(MyBlockingQueue.class);
        MyBlockingQueue<Order> mockStorageQueue = mock(MyBlockingQueue.class);
        Pizzeria mockPizzeria = mock(Pizzeria.class);

        // Генерируем список пекарей
        List<Baker> bakers = WorkerGenerator.generateBakers(5, mockOrderQueue, mockStorageQueue, mockPizzeria);

        // Проверяем, что количество сгенерированных пекарей равно ожидаемому
        assertEquals(5, bakers.size());
    }

    @Test
    public void testGenerateCouriers() {
        // Создаем моки очередей и пиццерии
        MyBlockingQueue<Order> mockStorageQueue = mock(MyBlockingQueue.class);
        Pizzeria mockPizzeria = mock(Pizzeria.class);

        // Генерируем список курьеров
        List<Courier> couriers = WorkerGenerator.generateCouriers(3, mockStorageQueue, mockPizzeria);

        // Проверяем, что количество сгенерированных курьеров равно ожидаемому
        assertEquals(3, couriers.size());
    }
}
