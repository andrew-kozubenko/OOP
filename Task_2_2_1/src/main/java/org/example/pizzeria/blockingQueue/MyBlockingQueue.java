package org.example.pizzeria.blockingQueue;

import org.example.pizzeria.interfaces.BlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue<T> implements BlockingQueue<T> {

    private final int size;
    private Queue<T> queue = new LinkedList<>();
    public MyBlockingQueue (int size) {
        this.size = size;
    }
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

    @Override
    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}
