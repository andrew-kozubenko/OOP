package org.example;

/**
 * Subject.
 */
public class Subject {
    private String name;

    private Integer grade;

    /**
     * setGrade.
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * getName.
     */
    public String getName() {
        return name;
    }

    /**
     * getGrade.
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * Subject.
     */
    public Subject(String name, Integer grade) {
        this.name = name;
        this.grade = grade;
    }

}
