package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


/**
 * Tree.
 */
public class Tree<T> implements Iterable<T> {
    /**
     * Tree's Node data.
     */
    private Node<T> value;

    /**
     * Getter.
     */
    public T getValue() {
        return value.getNodeValue();
    }

    /**
     * Constructor.
     */
    public Tree(T data) {
        value = new Node<>(data);
    }

    /**
     * Add child method.
     */
    public Tree<T> addChild(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }
        Tree<T> child = new Tree<>(data);
        value.addChild(child.value);
        return child;
    }

    /**
     * Add child method for subtree.
     */
    public void addChild(Tree<T> subtree) {
        if (subtree == null) {
            throw new IllegalArgumentException("Subtree cannot be null.");
        }
        value.addChild(subtree.value);
    }

    /**
     * Remove method.
     */
    public void remove() {
        if (value.getNodeParent() != null) {
            value.getNodeParent().removeChild(value);
        }
    }

    /**
     * Equals method.
     */
    public boolean equals(Tree<T> tree2) {
        return value.equals(tree2.value);
    }

    /**
     * Iterator.
     */
    public Iterator<T> iterator() {
        return new BreadthFirst<>(value);
    }

    /**
     * Iterator.
     */
    public Iterator<T> dfIterator() {
        return new DepthFirst<>(value);
    }

    /**
     * Breadth First Stream method.
     */
    public Stream<T> breadthFirstStream() {
        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(
                new BreadthFirst<>(value),
                Spliterator.ORDERED | Spliterator.NONNULL
        );
        return StreamSupport.stream(spliterator, false);
    }

    /**
     * Search method.
     */
    public Stream<T> search(Predicate<T> predicate) {
        return breadthFirstStream()
                .filter(node -> predicate.test(node));
    }

    /**
     * Overrided toString() method.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        printTree(value, "", result);
        return result.toString();
    }

    /**
     * Print tree.
     */
    private void printTree(Node<T> node, String prefix, StringBuilder result) {
        if (node != null) {
            if (result.length() != 0) {
                result.append(prefix);
                result.append("\\");
            } else {
                result.append(prefix);
            }

            result.append(node.getNodeValue());
            result.append("\n");

            List<Node<T>> children = node.getNodeChildren();
            for (int i = 0; i < children.size(); i++) {
                boolean isLast = i == children.size() - 1;
                String newPrefix = isLast ? prefix + "    " : prefix + "│   ";
                printTree(children.get(i), newPrefix, result);
            }
        }
    }
}
