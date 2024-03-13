package org.example.pizzeria.blockingQueue;

import org.example.pizzeria.interfaces.BlockingQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyBlockingQueueTest {

    @Test
    public void testPutAndTake() throws InterruptedException {
        int size = 5;
        BlockingQueue<Integer> queue = new MyBlockingQueue<>(size);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < size; i++) {
                    queue.put(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < size; i++) {
                    assertEquals(i, queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        BlockingQueue<Integer> queue = new MyBlockingQueue<>(5);
        assertTrue(queue.isEmpty());

        try {
            queue.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertFalse(queue.isEmpty());
    }
}
