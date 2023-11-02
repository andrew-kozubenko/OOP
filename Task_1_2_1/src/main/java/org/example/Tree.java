package org.example;

import com.sun.source.doctree.DeprecatedTree;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import java.util.function.Predicate;

public class Tree<T> {
    /**
     * Tree's Node<T> data.
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
    public Tree(T data){
        value = new Node<>(data);
    }

    /**
     * Add child method.
     */
    public Tree<T> addChild(T data) {
        Tree<T> child = new Tree<>(data);
        value.addChild(child.value);
        return child;
    }

    /**
     * Add child method for subtree.
     */
    public void addChild(Tree<T> subtree) {
        value.addChild(subtree.value);
    }

    /**
     * Remove method.
     */
    public void remove() {
        if (value.parent != null) {
            value.parent.removeChild(value);
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
     * Breadth First Stream method.
     */
    public Stream<T> breadthFirstStream() {
        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(
                new Tree.BreadthFirst<>(value),
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
     * Node class.
     */
    private static class Node<T> {
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
        private List<Node<T>> children;

        /**
         * Getter.
         */
        public T getNodeValue(){
            return value;
        }

        /**
         * Constructor.
         */
        public Node(T node_data) {
            value = node_data;
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
        }

        /**
         * Equals method.
         */
        public boolean equals(Node<T> secondNode) {
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

    /**
     * Depth First iterator.
     */
    private static class DepthFirst<T> implements Iterator<T> {
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
        public DepthFirst (Node<T> value) {
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
            stack.addAll(current.children);
            return current.value;
        }
    }

    /**
     * Breadth First iterator.
     */
    private static class BreadthFirst<T> implements Iterator<T> {
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
        public BreadthFirst (Node<T> value) {
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
            queue.addAll(current.children);
            return current.value;
        }
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
    private void printTree(Tree.Node<T> node, String prefix, StringBuilder result) {
        if (node != null) {
            if (result.length() != 0) {
                result.append(prefix);
                result.append("\\");
            } else {
                result.append(prefix);
            }

            result.append(node.value);
            result.append("\n");

            List<Tree.Node<T>> children = node.children;
            for (int i = 0; i < children.size(); i++) {
                boolean isLast = i == children.size() - 1;
                String newPrefix = isLast ? prefix + "    " : prefix + "│   ";
                printTree(children.get(i), newPrefix, result);
            }
        }
    }
}
