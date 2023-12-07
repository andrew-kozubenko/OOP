package org.example;

import java.util.*;

/**
 * StudentBook.
 */
public class StudentBook {
    private Map<Integer, List<Integer>> gradesBySemester;
    private int qualificationWork;
    private int lastSemester;
    private boolean hasDiplomaWithHonors;
    private boolean isEligibleForScholarship;

    /**
     * getGrades.
     */
    public List<Integer> getSemesterGrades(int semester) {
        return gradesBySemester.get(semester);
    }

    /**
     * getQualificationWork.
     */
    public int getQualificationWork() {
        return qualificationWork;
    }

    /**
     * setQualificationWork.
     */
    public void setQualificationWork(int qualificationWork) {
        if (qualificationWork >= 3 && qualificationWork <= 5) {
            this.qualificationWork = qualificationWork;
        } else {
            System.out.println("Оценка должна быть от 2 до 5.");
        }
    }

    /**
     * StudentBook.
     */
    public StudentBook() {
        this.gradesBySemester = new HashMap<>();
        this.hasDiplomaWithHonors = false;
        this.isEligibleForScholarship = false;
        this.qualificationWork = 0;
        this.lastSemester = 0;
    }

    /**
     * addGrade.
     */
    public void addGrade(int semester, int subjectIndex, int grade) {
        if (grade < 3 || grade > 5) {
            System.out.println("Оценка должна быть от 2 до 5.");
            return;
        } else if (semester < 1 || semester > 8) {
            System.out.println("Номер семестра должен быть от 2 до 5.");
        }

        gradesBySemester.computeIfAbsent(semester, k -> new ArrayList<>());
        gradesBySemester.get(semester).add(grade);

        lastSemester = Math.max(lastSemester, semester);
    }

    /**
     * calculateAverageGrade.
     */
    public double calculateAverageGrade() {
        double sum = 0;
        int count = 0;

        for (List<Integer> grades : gradesBySemester.values()) {
            for (int grade : grades) {
                sum += grade;
                count++;
            }
        }

        return count > 0 ? sum / count : 0.0;
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
        List<Integer> lastSemesterGrades = gradesBySemester.get(lastSemester);
        if (lastSemesterGrades == null || lastSemesterGrades.isEmpty()) {
            hasDiplomaWithHonors = false;
            return;
        }

        long excellentCount = lastSemesterGrades.stream().filter(grade -> grade == 5).count();
        long satisfactoryCount = lastSemesterGrades.stream().filter(grade -> grade == 3).count();

        if (excellentCount >= 0.75 * lastSemesterGrades.size()
                && satisfactoryCount == 0 && qualificationWork == 5) {
            hasDiplomaWithHonors = true;
        } else {
            hasDiplomaWithHonors = false;
        }
    }

    /**
     * updateScholarshipEligibility.
     */
    private void updateScholarshipEligibility() {
        List<Integer> lastSemesterGrades = gradesBySemester.get(lastSemester);
        if (lastSemesterGrades == null || lastSemesterGrades.isEmpty()) {
            isEligibleForScholarship = false;
            return;
        }

        long excellentCount = lastSemesterGrades.stream().filter(grade -> grade == 5).count();

        if ((double) excellentCount / lastSemesterGrades.size() == 1) {
            isEligibleForScholarship = true;
        } else {
            isEligibleForScholarship = false;
        }
    }
}