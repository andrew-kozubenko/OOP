package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * StudentBookTest.
 */
public class StudentBookTest {
    /**
     * testAddGrade.
     */
    @Test
    public void testAddGrade() {
        StudentBook studentRecordBook = new StudentBook();
        studentRecordBook.addGrade(1,1, 4);
        studentRecordBook.addGrade(1, 2, 5);
        studentRecordBook.addGrade(2,1, 4);
        studentRecordBook.addGrade(2, 2, 5);
        studentRecordBook.addGrade(3,1, 4);
        studentRecordBook.addGrade(3, 3, 5);

        ArrayList<Integer> expected1 = new ArrayList<>();
        expected1.add(4);
        expected1.add(5);

        ArrayList<Integer> expected2 = new ArrayList<>();
        expected2.add(4);
        expected2.add(5);

        ArrayList<Integer> expected3 = new ArrayList<>();
        expected3.add(4);
        expected3.add(5);

        assertEquals(expected1, studentRecordBook.getSemesterGrades(1));
        assertEquals(expected2, studentRecordBook.getSemesterGrades(2));
        assertEquals(expected3, studentRecordBook.getSemesterGrades(3));
    }

    /**
     * testCalculateAverageGrade.
     */
    @Test
    public void testCalculateAverageGrade() {
        StudentBook studentRecordBook = new StudentBook();
        studentRecordBook.addGrade(1,1, 3);
        studentRecordBook.addGrade(1, 2, 3);
        studentRecordBook.addGrade(2,1, 4);
        studentRecordBook.addGrade(2, 2, 5);

        double expected = 3.75;

        assertEquals(expected, studentRecordBook.calculateAverageGrade());
    }

    /**
     * testHasDiplomaWithHonors.
     */
    @Test
    public void testHasDiplomaWithHonors() {
        StudentBook studentRecordBook = new StudentBook();
        studentRecordBook.addGrade(1,1, 5);
        studentRecordBook.addGrade(1, 2, 5);
        studentRecordBook.addGrade(2,1, 4);
        studentRecordBook.addGrade(2, 2, 4);
        studentRecordBook.addGrade(3, 2, 5);
        studentRecordBook.addGrade(4, 2, 5);
        studentRecordBook.setQualificationWork(5);

        assertTrue(studentRecordBook.hasDiplomaWithHonors());
    }

    /**
     * testIsEligibleForScholarship.
     */
    @Test
    public void testIsEligibleForScholarship() {
        StudentBook studentRecordBook = new StudentBook();
        studentRecordBook.addGrade(1,1, 3);
        studentRecordBook.addGrade(1, 2, 3);
        studentRecordBook.addGrade(4,1, 5);
        studentRecordBook.addGrade(4, 2, 5);
        studentRecordBook.addGrade(4, 2, 5);
        studentRecordBook.addGrade(4, 2, 5);

        assertTrue(studentRecordBook.isEligibleForScholarship());
    }
}
