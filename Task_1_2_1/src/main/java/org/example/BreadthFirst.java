package org.example;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Breadth First iterator.
 */
public class BreadthFirst<T> implements Iterator<T> {
    /**
     * Current node.
     */
    private Node<T> current;

    /**
     * Queue.
     */
    private Queue<Node<T>> queue = new LinkedList<>();

    /**
     * Breadth First iterator consructor.
     */
    public BreadthFirst(Node<T> value) {
        queue.add(value);
    }

    /**
     * Overrided hasNext() method.
     */
    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /**
     * Overrided next() method.
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        current = queue.poll();
        queue.addAll(current.getNodeChildren());
        return current.getNodeValue();
    }
}
