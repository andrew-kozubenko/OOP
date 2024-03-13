package org.example.pizzeria.interfaces;

public interface BlockingQueue <E> {

    void put (E e) throws InterruptedException;

    E take() throws InterruptedException;
    boolean isEmpty();
}
