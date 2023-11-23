package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentBookTest {
    @Test
    public void testAddGrade() {
        StudentBook studentRecordBook = new StudentBook(5);
        studentRecordBook.addGrade(4);
        studentRecordBook.addGrade(5);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(5);

        assertTrue(expected.equals(studentRecordBook.getGrades()));
    }

    @Test
    public void testCalculateAverageGrade() {
        StudentBook studentRecordBook = new StudentBook(5);
        studentRecordBook.addGrade(2);
        studentRecordBook.addGrade(3);
        studentRecordBook.addGrade(4);
        studentRecordBook.addGrade(5);

        double expected = 3.5;

        assertTrue(expected == studentRecordBook.calculateAverageGrade());
    }
}
