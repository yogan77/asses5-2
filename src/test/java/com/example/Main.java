package com.example;

import java.util.Scanner;

/**
 * Application terminal controller layer.
 */
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
        if (scanner.hasNextInt()) {
            int subjectCount = scanner.nextInt();
            scanner.nextLine(); // Clear scanner buffering line
            
            for (int i = 0; i < subjectCount; i++) {
                System.out.println("\nSubject #" + (i + 1) + " Registration:");
                System.out.print(" -> Enter Subject Name: ");
                String subjectName = scanner.nextLine();
                
                System.out.print(" -> Enter Credit Value: ");
                int credits = 0;
                if (scanner.hasNextInt()) {
                    credits = scanner.nextInt();
                    scanner.nextLine(); // Clear scanner buffering line
                }
                
                student.registerCourse(subjectName, credits);
            }
            student.displayRegistrationReport();
        } else {
            System.out.println("Invalid structural sequence selection. Terminating.");
        }
        scanner.close();
    }
}
