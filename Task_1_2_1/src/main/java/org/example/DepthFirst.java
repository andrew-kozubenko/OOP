package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Depth First iterator.
 */
public class DepthFirst<T> implements Iterator<T> {
    /**
     * Current node.
     */
    private Node<T> current;

    /**
     * Stack.
     */
    private Stack<Node<T>> stack = new Stack<>();

    /**
     * Depth First iterator consructor.
     */
    public DepthFirst(Node<T> value) {
        stack.push(value);
    }

    /**
     * Overrided hasNext() method.
     */
    @Override
    public boolean hasNext() {
        return  !stack.isEmpty();
    }

    /**
     * Overrided next() method.
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        current = stack.pop();
        stack.addAll(current.getNodeChildren());
        return current.getNodeValue();
    }
}
