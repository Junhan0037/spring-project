package com.mvc.grade.domain;

public class GradeResult {
    private final double averageGrade;
    private final int totalCompletedCredit;

    public GradeResult(double averageGrade, int totalCompletedCredit) {
        this.averageGrade = averageGrade;
        this.totalCompletedCredit = totalCompletedCredit;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public int getTotalCompletedCredit() {
        return totalCompletedCredit;
    }
}
