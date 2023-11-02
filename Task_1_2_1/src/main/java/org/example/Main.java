package org.example;

import java.util.function.Predicate;

/**
 * Main.
 */
public class Main {
    public static void main(String[] args) {
        Tree<String> tree = new Tree<>("R1");
        var a = tree.addChild("A");
        var b = a.addChild("B");
        boolean c = a.equals(b);
        Tree<String> subtree = new Tree<>("R2");
        subtree.addChild("C");
        subtree.addChild("D");
        tree.addChild(subtree);
        b.remove();
        b.remove();
        System.out.println(tree);
        var treeIter = tree.iterator();
        while (treeIter.hasNext()) {
            System.out.println(treeIter.next());
        }

        Tree<Integer> tree1 = new Tree<>(1);
        Tree<Integer> child1 = tree1.addChild(2);
        Tree<Integer> child2 = tree1.addChild(3);
        Tree<Integer> child3 = child1.addChild(4);
        Tree<Integer> child4 = child1.addChild(5);

        Predicate<Integer> isEven = n -> n % 2 == 0;
        var evenNodes = tree1.search(isEven);

        evenNodes.forEach(System.out::println);
    }
}