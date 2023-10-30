package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

public class TreeTest {

    @Test
    public void testAddChild() {
        Tree<String> tree = new Tree<>("root");
        Tree<String> child1 = tree.addChild("child1");
        Tree<String> child2 = tree.addChild("child2");
        Tree<String> child3 = child1.addChild("child3");

        var iterator = tree.iterator();

        assertEquals("root", tree.getValue());
        assertTrue(iterator.hasNext());
        assertEquals("root", iterator.next());
        assertEquals("child1", iterator.next());
        assertEquals("child2", iterator.next());
        assertEquals("child3", iterator.next());
    }

    @Test
    public void testEquals() {
        Tree<String> tree1 = new Tree<>("root");
        Tree<String> child1 = tree1.addChild("child1");
        Tree<String> child2 = tree1.addChild("child2");

        Tree<String> tree2 = new Tree<>("root");
        Tree<String> child3 = tree2.addChild("child1");
        Tree<String> child4 = tree2.addChild("child2");

        Tree<String> tree3 = new Tree<>("root");
        Tree<String> child5 = tree3.addChild("child1");
        Tree<String> child6 = child5.addChild("child2");

        assertTrue(tree1.equals(tree2));
        assertFalse(tree2.equals(tree3));
    }

    @Test
    public void testRemove() {
        Tree<String> tree1 = new Tree<>("root");
        Tree<String> child1 = tree1.addChild("child1");
        Tree<String> child2 = tree1.addChild("child2");

        Tree<String> tree2 = new Tree<>("root");
        Tree<String> child3 = tree2.addChild("child2");

        child1.remove();

        assertTrue(tree1.equals(tree2));
    }

    @Test
    public void testIterator() {
        Tree<String> tree = new Tree<>("root");
        Tree<String> child1 = tree.addChild("child1");
        Tree<String> child2 = child1.addChild("child2");

        var iterator = tree.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("root", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("child1", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("child2", iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testToString() {
        Tree<String> tree = new Tree<>("root");
        Tree<String> child1 = tree.addChild("child1");
        Tree<String> child2 = tree.addChild("child2");
        Tree<String> child1_1 = child1.addChild("child1_1");
        Tree<String> child1_2 = child1.addChild("child1_2");
        Tree<String> child2_1 = child2.addChild("child2_1");

        String expectedString =
                "root\n" +
                "│   \\child1\n" +
                "│   │   \\child1_1\n" +
                "│       \\child1_2\n" +
                "    \\child2\n" +
                "        \\child2_1\n";

        assertEquals(expectedString, tree.toString());
    }

    @Test
    public void seachTest(){
        Tree<String> tree1 = new Tree<>("so");
        Tree<String> child1 = tree1.addChild("so");
        Tree<String> child2 = tree1.addChild("Yes");
        Tree<String> child1_1 = child1.addChild("so");
        Tree<String> child1_2 = child1.addChild("Yes");

        Predicate<String> eQ = n -> n.equals("Yes");
        var equalYESNodes = tree1.search(eQ);

        equalYESNodes.forEach(node -> assertEquals("Yes", node));
    }
}
