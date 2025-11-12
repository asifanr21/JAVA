import java.util.*;
import CIE.*;
import SEE.External;

public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Persnal[] p = new Persnal[n];
        Internals[] in = new Internals[n];
        External[] ex = new External[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));

            System.out.print("USN: ");
            String usn = sc.next();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Semester: ");
            int sem = sc.nextInt();

            int[] internalMarks = new int[5];
            System.out.println("Enter 5 internal marks: ");
            for (int j = 0; j < 5; j++) {
                internalMarks[j] = sc.nextInt();
            }

            int[] seeMarks = new int[5];
            System.out.println("Enter 5 SEE marks: ");
            for (int j = 0; j < 5; j++) {
                seeMarks[j] = sc.nextInt();
            }

            p[i] = new Persnal(usn, name, sem);
            in[i] = new Internals(internalMarks);
            ex[i] = new External(usn, name, sem, seeMarks);
        }
        
        System.out.println("\n----- FINAL MARKS OF STUDENTS -----");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            p[i].display();

            int[] finalMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                
                finalMarks[j] = in[i].internalMarks[j] + (ex[i].seeMarks[j] / 2);
            }

            System.out.print("Final Marks (out of 100 each): ");
            for (int j = 0; j < 5; j++) {
                System.out.print(finalMarks[j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}