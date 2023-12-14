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
     * satisfactoryCount.
     */
    public long satisfactoryCount() {
        return subjects.stream()
                .filter(sub -> sub.getGrade() == 3)
                .count();
    }

    /**
     * calculateAverageGrade.
     */
    public double calculateAverageGrade() {
        if (subjects.isEmpty()) {
            return 0.0;
        }

        return subjects.stream()
                .mapToDouble(Subject::getGrade)
                .average()
                .orElse(0.0);
    }
}
