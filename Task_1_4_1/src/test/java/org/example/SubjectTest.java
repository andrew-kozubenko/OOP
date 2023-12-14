package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * StudentBookTest.
 */
public class SubjectTest {
    /**
     * testSetGrade.
     */
    @Test
    void testSetGrade() {
        Subject subject = new Subject("Math", 4);
        subject.setGrade(5);
        assertEquals(5, subject.getGrade());
    }

    /**
     * testGetName.
     */
    @Test
    void testGetName() {
        Subject subject = new Subject("Physics", 3);
        assertEquals("Physics", subject.getName());
    }

    /**
     * testGetGrade.
     */
    @Test
    void testGetGrade() {
        Subject subject = new Subject("English", 2);
        assertEquals(2, subject.getGrade());
    }
}
