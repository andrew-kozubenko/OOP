package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * StudentBookTest.
 */
public class SemesterTest {
    /**
     * testAddGrade.
     */
    @Test
    void testAddGrade() {
        Semester semester = new Semester(1);
        semester.addGrade("Math", 4);
        assertEquals(1, semester.getSubjects().size());
    }

    /**
     * testCalculateAverageGrade.
     */
    @Test
    void testCalculateAverageGrade() {
        Semester semester = new Semester(1);
        semester.addGrade("Math", 4);
        semester.addGrade("Physics", 5);
        assertEquals(4.5, semester.calculateAverageGrade(), 0.01);
    }

    /**
     * testCalculateAverageGradeEmptySubjects.
     */
    @Test
    void testCalculateAverageGradeEmptySubjects() {
        Semester semester = new Semester(1);
        assertEquals(0.0, semester.calculateAverageGrade(), 0.01);
    }

    /**
     * testCalculateAverageGradeWithZeroGrades.
     */
    @Test
    void testCalculateAverageGradeWithZeroGrades() {
        Semester semester = new Semester(1);
        semester.addGrade("Math", 0);
        semester.addGrade("Physics", 0);
        assertEquals(0.0, semester.calculateAverageGrade(), 0.01);
    }

    /**
     * testCalculateAverageGradeWithNegativeGrades.
     */
    @Test
    void testCalculateAverageGradeWithNegativeGrades() {
        Semester semester = new Semester(1);
        semester.addGrade("Math", -2);
        semester.addGrade("Physics", -3);
        assertEquals(-2.5, semester.calculateAverageGrade(), 0.01);
    }

    /**
     * testCalculateAverageGradeWithMixedGrades.
     */
    @Test
    void testCalculateAverageGradeWithMixedGrades() {
        Semester semester = new Semester(1);
        semester.addGrade("Math", 4);
        semester.addGrade("Physics", -2);
        assertEquals(1.0, semester.calculateAverageGrade(), 0.01);
    }
}
