import java.util.Scanner;

class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    int n;  

   
    Student(int n) {
        this.n = n;
        credits = new int[n];
        marks = new int[n];
    }

   
    void acceptDetails(Scanner sc) {
        System.out.println("Entering student details...");
        
        System.out.print("Enter USN: ");
        usn = sc.nextLine();  

        System.out.print("Enter Name: ");
        name = sc.nextLine();  

        System.out.println("Enter credits and marks for each subject:");
        for (int i = 0; i < n; i++) {
            System.out.print("Subject " + (i + 1) + " credits: ");
            credits[i] = sc.nextInt();  

            System.out.print("Subject " + (i + 1) + " marks: ");
            marks[i] = sc.nextInt(); 
        }
    }

   
    void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);

        System.out.println("Subjects details:");
        for (int i = 0; i < n; i++) {
            System.out.println("Subject " + (i + 1) + " - Credits: " + credits[i] + ", Marks: " + marks[i]);
        }
    }

    
    double calculateSGPA() {
        int totalCredits = 0;
        int weightedGradePoints = 0;

        for (int i = 0; i < n; i++) {
            int gradePoint = getGradePoint(marks[i]);
            weightedGradePoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        if (totalCredits == 0) return 0;
        return (double) weightedGradePoints / totalCredits;
    }

    
    private int getGradePoint(int marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else if (marks >= 40) return 5;
        else return 0;
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Program started. Enter number of subjects: ");
            System.out.print("Enter number of subjects: ");
            int n = sc.nextInt();
            sc.nextLine();  

            System.out.println("Enter student details now.");
            Student s = new Student(n);
            s.acceptDetails(sc);  
            s.displayDetails();

            double sgpa = s.calculateSGPA();
            System.out.printf("SGPA: %.2f\n", sgpa);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close(); 
        }
    }
}
