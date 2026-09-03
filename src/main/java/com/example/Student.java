package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Embedded Course Class to keep the project strictly restricted to two files.
 */
class Course {
    private final String courseName;
    private final int credits;

    public Course(String courseName, int credits) {
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }
}

/**
 * Handles student registration and qualification evaluations.
 */
public class Student {
    private final String name;
    private final String studentId;
    private final List<Course> registeredCourses;
    private static final int MINIMUM_CREDIT_THRESHOLD = 15;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(String courseName, int credits) {
        registeredCourses.add(new Course(courseName, credits));
    }

    public int calculateTotalCredits() {
        int total = 0;
        for (Course course : registeredCourses) {
            total += course.getCredits();
        }
        return total;
    }

    public boolean isEligible() {
        return calculateTotalCredits() >= MINIMUM_CREDIT_THRESHOLD;
    }

    public void displayRegistrationReport() {
        int totalCredits = calculateTotalCredits();
        System.out.println("\n============ REGISTRATION REPORT ============");
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + name);
        System.out.println("---------------------------------------------");
        System.out.println("Registered Subjects:");
        
        if (registeredCourses.isEmpty()) {
            System.out.println(" No courses registered yet.");
        } else {
            for (Course course : registeredCourses) {
                System.out.printf(" - %-25s (%d Credits)%n", course.getCourseName(), course.getCredits());
            }
        }
        
        System.out.println("---------------------------------------------");
        System.out.println("Total Credits Accumulated : " + totalCredits);
        System.out.println("Eligibility Status         : " + (isEligible() ? "ELIGIBLE" : "NOT ELIGIBLE (Requires min. 15 credits)"));
        System.out.println("=============================================\n");
    }
}
