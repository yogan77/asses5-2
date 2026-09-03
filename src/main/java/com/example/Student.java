package com.registration;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String studentId;
    private List<Course> registeredCourses;
    private static final int MINIMUM_CREDIT_THRESHOLD = 15;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (course != null) {
            registeredCourses.add(course);
        }
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
