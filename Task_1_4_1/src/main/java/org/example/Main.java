package org.example;

/**
 * Main.
 */
public class Main {
    /**
     * main.
     */
    public static void main(String[] args) {
        StudentBook studentRecordBook = new StudentBook();

        studentRecordBook.addGrade(1, 1, 5);
        studentRecordBook.addGrade(1, 2, 4);
        studentRecordBook.addGrade(1, 3, 4);
        studentRecordBook.addGrade(1, 4, 5);

        System.out.println("Средний балл: " + studentRecordBook.calculateAverageGrade());
        System.out.println("Диплом с отличием: " + studentRecordBook.hasDiplomaWithHonors());
        System.out.println("Повышенная стипендия: " + studentRecordBook.isEligibleForScholarship());
    }
}