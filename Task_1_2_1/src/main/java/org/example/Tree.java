package org.example;

import com.sun.source.doctree.DeprecatedTree;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import java.util.function.Predicate;

public class Tree<T> {
    private Node<T> value;

    public T getValue() {
        return value.getNodeValue();
    }

    public Tree (T data){
        value = new Node <> (data);
    }

    public Tree<T> addChild(T data) {
        Tree<T> child = new Tree<> (data);
        value.addChild(child.value);
        return child;
    }

    public void addChild(Tree<T> subtree) {
        value.addChild(subtree.value);
    }

    public void remove() {
        if (value.parent != null) {
            value.parent.removeChild(value);
        }
    }

    public boolean equals(Tree<T> tree2) {
        return value.equals(tree2.value);
    }

    public Iterator<T> iterator() {
        return new BreadthFirst<>(value);
    }

    public Stream<T> breadthFirstStream() {
        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(
                new Tree.BreadthFirst<>(value),
                Spliterator.ORDERED | Spliterator.NONNULL
        );
        return StreamSupport.stream(spliterator, false);
    }

    public Stream<T> search(Predicate<T> predicate) {
        return breadthFirstStream()
                .filter(node -> predicate.test(node));
    }

    private static class Node<T> {
        private T value;

        private Node<T> parent;

        private List<Node<T>> children;

        public T getNodeValue(){
            return value;
        }

        public Node (T node_data) {
            value = node_data;
            children = new ArrayList<>();
        }

        public void addChild(Node<T> child) {
            child.parent = this;
            children.add(child);
        }

        public void removeChild(Node<T> child) {
            children.remove(child);
        }

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

    private static class DepthFirst<T> implements Iterator<T> {
        private Node<T> current;
        private Stack<Node<T>> stack = new Stack<>();
        public DepthFirst (Node<T> value) {
            stack.push(value);
        }

        @Override
        public boolean hasNext() {
            return  !stack.isEmpty();
        }

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

    private static class BreadthFirst<T> implements Iterator<T> {
        private Node<T> current;

        private Queue<Node<T>> queue = new LinkedList<>();

        public BreadthFirst (Node<T> value) {
            queue.add(value);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        printTree(value, "", result);
        return result.toString();
    }

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
