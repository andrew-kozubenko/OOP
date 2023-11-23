package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentBook {
    private ArrayList<Integer> grades;
    private int qualificationWork;
    private boolean hasDiplomaWithHonors;
    private boolean isEligibleForScholarship;

    public ArrayList<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void setGrades(ArrayList<Integer> grades) {
        this.grades = new ArrayList<>(grades);
    }

    public int getQualificationWork() {
        return qualificationWork;
    }

    public void setQualificationWork(int qualificationWork) {
        this.qualificationWork = qualificationWork;
    }

    public boolean isHasDiplomaWithHonors() {
        return hasDiplomaWithHonors;
    }

    public void setHasDiplomaWithHonors(boolean hasDiplomaWithHonors) {
        this.hasDiplomaWithHonors = hasDiplomaWithHonors;
    }

    public void setEligibleForScholarship(boolean eligibleForScholarship) {
        isEligibleForScholarship = eligibleForScholarship;
    }

    public StudentBook(int qualificationWork) {
        this.grades = new ArrayList<>();
        this.hasDiplomaWithHonors = false;
        this.isEligibleForScholarship = false;
        if (qualificationWork >= 2 && qualificationWork <= 5) {
            this.qualificationWork = qualificationWork;
        } else {
            throw new IllegalArgumentException("Invalid qualification work grade");
        }

    }

    public void addGrade(int grade) {
        if (grade >= 2 && grade <= 5) { // Предполагается, что допустимые оценки - от 2 до 5
            grades.add(grade);
            updateDiplomaWithHonors();
            updateScholarshipEligibility();
        } else {
            System.out.println("Оценка должна быть от 2 до 5.");
        }
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }

    private void updateDiplomaWithHonors() {
        int lastGrade = grades.isEmpty() ? 0 : grades.get(grades.size() - 1);

        long excellentCount = grades.stream().filter(grade -> grade == 5).count();
        long satisfactoryCount = grades.stream().filter(grade -> grade == 3).count();

        if (lastGrade == 5 && excellentCount >= 0.75 * grades.size() &&
                satisfactoryCount == 0 && qualificationWork == 5) {
            hasDiplomaWithHonors = true;
        } else {
            hasDiplomaWithHonors = false;
        }
    }

    private void updateScholarshipEligibility() {
        int lastGrade = grades.isEmpty() ? 0 : grades.get(grades.size() - 1);

        if (lastGrade == 5) {
            isEligibleForScholarship = true;
        } else {
            isEligibleForScholarship = false;
        }
    }

    public boolean hasDiplomaWithHonors() {
        return hasDiplomaWithHonors;
    }

    public boolean isEligibleForScholarship() {
        return isEligibleForScholarship;
    }
}