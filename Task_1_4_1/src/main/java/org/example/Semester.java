package org.example;

import java.util.*;

/**
 * Semester.
 */
public class Semester {
    private int number;
    private List<Subject> subjects = new ArrayList<>();

    /**
     * getSubjects.
     */
    public List<Subject> getSubjects() {
        return subjects;
    }

    /**
     * Semester.
     */
    public Semester(int number) {
        this.number = number;
    }

    /**
     * addGrade.
     */
    public void addGrade(String name, Integer grade) {
        Subject subject = new Subject(name, grade);
        subjects.add(subject);
    }

    /**
     * calculateAverageGrade.
     */
    public double calculateAverageGrade() {
        if (subjects.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (Subject subject : subjects) {
            sum += subject.getGrade();
        }

        return sum / subjects.size();
    }
}
