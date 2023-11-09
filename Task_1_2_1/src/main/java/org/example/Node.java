package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Node class.
 */
public class Node<T> {
    /**
     * Value.
     */
    private T value;

    /**
     * Parent.
     */
    private Node<T> parent;

    /**
     * Children.
     */
    private final List<Node<T>> children;

    /**
     * Getter.
     */
    public T getNodeValue() {
        return value;
    }

    /**
     * Getter.
     */
    public Node<T> getNodeParent() {
        return parent;
    }

    /**
     * Getter.
     */
    public List<Node<T>> getNodeChildren() {
        return children;
    }

    /**
     * Constructor.
     */
    public Node(T nodeData) {
        value = nodeData;
        children = new ArrayList<>();
    }

    /**
     * Add child method.
     */
    public void addChild(Node<T> child) {
        child.parent = this;
        children.add(child);
    }

    /**
     * Remove child method.
     */
    public void removeChild(Node<T> child) {
        children.remove(child);
        children.addAll(child.getNodeChildren());
    }

    /**
     * Equals method.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Node<T> secondNode = (Node<T>) obj;

        if (!value.equals(secondNode.value) || children.size() != secondNode.children.size()) {
            return false;
        }

        for (int i = 0; i < children.size(); i++) {
            if (!children.get(i).equals(secondNode.children.get(i))) {
                return false;
            }
        }

        return true;
    }
}