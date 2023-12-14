package org.example;

/**
 * Main.
 */
public class Main {
    /**
     * main.
     */
    public static void main(String[] args) {
        StudentBook studentBook = new StudentBook();

        studentBook.addGrade(1, "Digital platforms", 5);
        studentBook.addGrade(1, "Beans beating", 5);
        studentBook.addGrade(1, "Some math", 3);
        studentBook.addGrade(2, "Some math", 5);
        studentBook.addGrade(2, "Beans beating", 4);
        studentBook.addGrade(2, "Some frogging", 5);
        studentBook.addGrade(2, "Roof running", 5);
        studentBook.setQualificationWork(5);

        System.out.println("Средний балл: " + studentBook.calculateAverageGrade());
        System.out.println("Диплом с отличием: " + studentBook.hasDiplomaWithHonors());
        System.out.println("Повышенная стипендия: " + studentBook.isEligibleForScholarship());
    }
}