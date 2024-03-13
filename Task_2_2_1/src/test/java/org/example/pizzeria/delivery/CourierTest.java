package org.example.pizzeria.delivery;

import org.example.pizzeria.Pizzeria;
import org.example.pizzeria.blockingQueue.MyBlockingQueue;
import org.example.pizzeria.orders.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CourierTest {
    private MyBlockingQueue<Order> mockStorageQueue;
    private Pizzeria mockPizzeria;

    @BeforeEach
    public void setUp() {
        mockStorageQueue = mock(MyBlockingQueue.class);
        mockPizzeria = mock(Pizzeria.class);
    }

    @Test
    public void testDeliveryProcess() throws InterruptedException {
        // Создаем экземпляр курьера
        Courier courier = new Courier("John", 80, mockStorageQueue, mockPizzeria);

        // Создаем мокированный заказ
        Order mockOrder = mock(Order.class);

        // Настройка мокированных объектов для тестирования сценария
        when(mockStorageQueue.take()).thenReturn(mockOrder);

        // Вызываем метод deliver() напрямую
        courier.deliver();

        // Проверяем, что методы инкремента и декремента вызывались
        verify(mockPizzeria, times(1)).incrementCouriers();
        verify(mockPizzeria, times(1)).decrementCouriers();
    }

    @Test
    public void testConstructorWithInvalidEfficiencyPerc() {
        try {
            Courier courier = new Courier("John", 110, mockStorageQueue, mockPizzeria);
        } catch (IllegalArgumentException e) {
            assertEquals("Значение параметра efficiencyСoefficient должно лежать в диапазоне [0, 100]", e.getMessage());
        }
    }
}
