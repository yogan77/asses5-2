package com.registration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Course Registration Console Interface ---");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        
        Student student = new Student(name, studentId);
        
        System.out.print("How many subjects do you want to register? ");
        int subjectCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        for (int i = 0; i < subjectCount; i++) {
            System.out.println("\nSubject #" + (i + 1) + " Registration:");
            System.out.print(" -> Enter Subject Name: ");
            String subjectName = scanner.nextLine();
            
            System.out.print(" -> Enter Credit Value: ");
            int credits = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            student.registerCourse(new Course(subjectName, credits));
        }
        
        // Output evaluation summary
        student.displayRegistrationReport();
        
        scanner.close();
    }
}
