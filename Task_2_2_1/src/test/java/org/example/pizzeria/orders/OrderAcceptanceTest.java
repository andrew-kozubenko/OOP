package org.example.pizzeria.orders;

import static org.mockito.Mockito.*;

import org.example.pizzeria.blockingQueue.MyBlockingQueue;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * OrderAcceptanceTest.
 */
public class OrderAcceptanceTest {
    /**
     * testOrderAcceptance.
     */
    @Test
    public void testOrderAcceptance() throws InterruptedException {
        // Создание мока для очереди заказов
        MyBlockingQueue<Order> mockOrderQueue = mock(MyBlockingQueue.class);

        // Создание списка заказов
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Customer1", "Address1", new ArrayList<>()));
        orderList.add(new Order("Customer2", "Address2", new ArrayList<>()));
        orderList.add(new Order("Customer3", "Address3", new ArrayList<>()));

        // Создание экземпляра класса OrderAcceptance
        OrderAcceptance orderAcceptance = new OrderAcceptance(mockOrderQueue, orderList);

        // Запуск потока
        orderAcceptance.start();

        // Проверка того, что каждый заказ был добавлен в очередь
        Thread.sleep(6500); // Ждем, чтобы все заказы были обработаны
        verify(mockOrderQueue, times(1)).put(orderList.get(0));
        verify(mockOrderQueue, times(1)).put(orderList.get(1));
        verify(mockOrderQueue, times(1)).put(orderList.get(2));
    }
}
