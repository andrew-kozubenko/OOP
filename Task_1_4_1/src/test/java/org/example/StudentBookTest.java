package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * StudentBookTest.
 */
public class StudentBookTest {
    /**
     * testAddGrade.
     */
    @Test
    void testAddGrade() {
        StudentBook studentBook = new StudentBook();
        studentBook.addGrade(1, "Math", 4);
        assertEquals(4, studentBook.getAllSubjectsWithLastGrades().get(0).getGrade());
    }

    /**
     * testCalculateAverageGrade.
     */
    @Test
    void testCalculateAverageGrade() {
        StudentBook studentBook = new StudentBook();
        studentBook.addGrade(1, "Math", 4);
        studentBook.addGrade(1, "Physics", 5);
        assertEquals(4.5, studentBook.calculateAverageGrade());
    }

    /**
     * testHasDiplomaWithHonors.
     */
    @Test
    void testHasDiplomaWithHonors() {
        StudentBook studentBook = new StudentBook();
        studentBook.addGrade(1, "Math", 5);
        studentBook.setQualificationWork(5);
        assertTrue(studentBook.isEligibleForScholarship());
    }

    /**
     * testIsEligibleForScholarship.
     */
    @Test
    void testIsEligibleForScholarship() {
        StudentBook studentBook = new StudentBook();
        studentBook.addGrade(1, "Math", 5);
        assertTrue(studentBook.isEligibleForScholarship());
    }
}
