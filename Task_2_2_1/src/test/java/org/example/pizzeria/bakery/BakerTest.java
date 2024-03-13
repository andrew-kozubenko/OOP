package org.example.pizzeria.bakery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.example.pizzeria.Pizzeria;
import org.example.pizzeria.blockingQueue.MyBlockingQueue;
import org.example.pizzeria.orders.Order;
import org.example.pizzeria.pizza.Pizza;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * BakerTest.
 */
public class BakerTest {
    private MyBlockingQueue<Order> mockOrderQueue;
    private MyBlockingQueue<Order> mockStorageQueue;
    private Pizzeria mockPizzeria;

    /**
     * setUp.
     */
    @BeforeEach
    public void setUp() {
        mockOrderQueue = mock(MyBlockingQueue.class);
        mockStorageQueue = mock(MyBlockingQueue.class);
        mockPizzeria = mock(Pizzeria.class);
    }

    /**
     * testCookingProcess.
     */
    @Test
    public void testCookingProcess() throws InterruptedException {
        // Создаем моки
        MyBlockingQueue<Order> mockOrderQueue = mock(MyBlockingQueue.class);
        MyBlockingQueue<Order> mockStorageQueue = mock(MyBlockingQueue.class);
        Pizzeria mockPizzeria = mock(Pizzeria.class);

        // Создаем экземпляр бекера
        Baker baker = new Baker("John", 80,
                mockOrderQueue, mockStorageQueue, mockPizzeria);

        // Создаем мокированный заказ и пиццы
        Order mockOrder = mock(Order.class);
        Pizza mockPizza1 = mock(Pizza.class);
        Pizza mockPizza2 = mock(Pizza.class);

        // Настройка мокированных объектов для тестирования сценария
        when(mockOrderQueue.take()).thenReturn(mockOrder);
        when(mockOrder.getOrder()).thenReturn(List.<Pizza>of(mockPizza1, mockPizza2));
        when(mockPizza1.getCookingTime()).thenReturn(10);
        when(mockPizza2.getCookingTime()).thenReturn(15);

        // Вызываем метод cook() напрямую
        baker.cook();

        // Проверяем, что методы инкремента и декремента вызывались
        verify(mockPizzeria, times(1)).incrementBakers();
        verify(mockPizzeria, times(1)).decrementBakers();
    }

    /**
     * testConstructorWithInvalidEfficiencyPerc.
     */
    @Test
    public void testConstructorWithInvalidEfficiencyPerc() {
        try {
            Baker baker = new Baker("John", 110,
                    mockOrderQueue, mockStorageQueue, mockPizzeria);
        } catch (IllegalArgumentException e) {
            assertEquals(
                    "Значение параметра efficiencyСoefficient " +
                            "должно лежать в диапазоне [0, 100]",
                    e.getMessage());
        }
    }
}
