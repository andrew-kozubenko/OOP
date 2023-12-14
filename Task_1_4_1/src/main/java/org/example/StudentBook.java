package org.example;

import java.util.*;

/**
 * StudentBook.
 */
public class StudentBook {
    private List<Semester> semesters;
    private Integer lastSemester;
    private Integer qualificationWork;
    private boolean hasDiplomaWithHonors;
    private boolean isEligibleForScholarship;
    private List<Subject> allSubjectsWithLastGrades;

    /**
     * getAllSubjectsWithLastGrades.
     */
    public List<Subject> getAllSubjectsWithLastGrades() {
        return allSubjectsWithLastGrades;
    }

    /**
     * StudentBook.
     */
    public StudentBook() {
        this.semesters = new ArrayList<>();
        this.qualificationWork = 0;
        this.lastSemester = 1;
        allSubjectsWithLastGrades = new ArrayList<>();
        initializeSemesters();
    }

    /**
     * initializeSemesters.
     */
    private void initializeSemesters() {
        for (int i = 1; i <= 8; i++) {
            Semester semester = new Semester(i);
            semesters.add(semester);
        }
    }

    /**
     * addGrade.
     */
    public void addGrade(Integer semesterNumber, String subjectName, Integer grade) {
        if (semesterNumber < 1 || semesterNumber > 8) {
            throw new IllegalArgumentException();
        }

        if (grade < 3 || grade > 5) {
            throw new IllegalArgumentException();
        }

        if (semesterNumber > lastSemester) {
            lastSemester = semesterNumber;
        }

        Subject subject = allSubjectsWithLastGrades.stream()
                .filter(sub -> sub.getName().equals(subjectName)).findFirst().orElse(null);

        if (subject != null) {
            if (semesterNumber >= lastSemester) {
                subject.setGrade(grade);
            }
        } else {
            Subject newSubject = new Subject(subjectName, grade);
            allSubjectsWithLastGrades.add(newSubject);
        }

        Semester semester = semesters.get(semesterNumber);
        semester.addGrade(subjectName, grade);
    }

    /**
     * calculateAverageGrade.
     */
    public double calculateAverageGrade() {
        double sum = 0;
        int count = 0;

        for (Semester semester : semesters) {
            double semesterAvg = semester.calculateAverageGrade();
            sum += semesterAvg;
            if (semesterAvg != 0.0) {
                count++;
            }
        }

        return count > 0 ? sum / count : 0.0;
    }

    /**
     * setQualificationWork.
     */
    public void setQualificationWork(Integer qualificationWork) {
        if (qualificationWork < 3 || qualificationWork > 5) {
            throw new IllegalArgumentException();
        }
        this.qualificationWork = qualificationWork;
        updateDiplomaWithHonors();
    }

    /**
     * hasDiplomaWithHonors.
     */
    public boolean hasDiplomaWithHonors() {
        updateDiplomaWithHonors();
        return hasDiplomaWithHonors;
    }

    /**
     * isEligibleForScholarship.
     */
    public boolean isEligibleForScholarship() {
        updateScholarshipEligibility();
        return isEligibleForScholarship;
    }

    /**
     * updateDiplomaWithHonors.
     */
    private void updateDiplomaWithHonors() {
        if (allSubjectsWithLastGrades == null || allSubjectsWithLastGrades.isEmpty()) {
            throw new NoSuchElementException();
        }

        long excellentCount = allSubjectsWithLastGrades.stream()
                .filter(sub -> sub.getGrade() == 5).count();
        long satisfactoryCount = allSubjectsWithLastGrades.stream()
                .filter(sub -> sub.getGrade() == 3).count();

        hasDiplomaWithHonors = excellentCount >= 0.75 * allSubjectsWithLastGrades.size()
                && satisfactoryCount == 0 && qualificationWork == 5;
    }

    /**
     * updateScholarshipEligibility.
     */
    private void updateScholarshipEligibility() {
        Semester semester = semesters.get(lastSemester);
        if (semester == null) {
            throw new NoSuchElementException();
        }

        isEligibleForScholarship = semester.calculateAverageGrade() == 5;
    }
}