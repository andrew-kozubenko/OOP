package org.example;

public class Main {
    public static void main(String[] args) {
        StudentBook studentRecordBook = new StudentBook(5);

        studentRecordBook.addGrade(4);
        studentRecordBook.addGrade(5);
        studentRecordBook.addGrade(4);
        studentRecordBook.addGrade(5);

        System.out.println("Средний балл: " + studentRecordBook.calculateAverageGrade());
        System.out.println("Диплом с отличием: " + studentRecordBook.hasDiplomaWithHonors());
        System.out.println("Повышенная стипендия: " + studentRecordBook.isEligibleForScholarship());
    }
}