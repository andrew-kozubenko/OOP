package org.example.pizzeria.interfaces;

/**
 * BlockingQueue.
 */
public interface BlockingQueue <E> {
    /**
     * put.
     */
    void put (E e) throws InterruptedException;

    /**
     * take.
     */
    E take() throws InterruptedException;

    /**
     * isEmpty.
     */
    boolean isEmpty();
}
