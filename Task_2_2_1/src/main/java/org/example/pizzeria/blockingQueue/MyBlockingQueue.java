package org.example.pizzeria.blockingQueue;

import org.example.pizzeria.interfaces.BlockingQueue;
import java.util.LinkedList;
import java.util.Queue;

/**
 * MyBlockingQueue.
 */
public class MyBlockingQueue<T> implements BlockingQueue<T> {
    private final int size;
    private Queue<T> queue = new LinkedList<>();

    /**
     * MyBlockingQueue.
     */
    public MyBlockingQueue (int size) {
        this.size = size;
    }

    /**
     * put.
     */
    @Override
    public synchronized void put(T item) throws InterruptedException {
        while(queue.size() == size) {
            wait();
        }
        if (queue.isEmpty()) {
            notifyAll();
        }
        queue.offer(item);
    }

    /**
     * take.
     */
    @Override
    public synchronized T take() throws InterruptedException {
        while(queue.isEmpty()) {
            wait();
        }
        if (queue.size() == size) {
            notifyAll();
        }
        return queue.poll();
    }

    /**
     * isEmpty.
     */
    @Override
    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}
