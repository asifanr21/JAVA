import java.util.Scanner;
class Student1
{
    int[] usn;
    String[] name;
    int[] marks;
    int n;

    Student1(int n)
    {
        this.n=n;
        usn=new int[n];
        name=new String[n];
        marks=new int[n];
    }

    void details(Scanner sc)
    {
        System.out.println("Student Details...:");
        for(int i=0; i<n; i++)
        {
            System.out.print("Enter the"+(i+1)+" Student USN:");
            usn[i]=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the"+(i+1)+" Student Name:");
            name[i]=sc.nextLine();
            System.out.print("Enter the"+(i+1)+" Student Marks:");
            marks[i]=sc.nextInt();
            sc.nextLine();
        }
    }

    void display()
    {
        for(int i=0; i<n; i++){
            System.out.println("Student"+(i+1)+" Usn:"+usn[i]);
            System.out.println("Student"+(i+1)+" Name:"+name[i]);
            System.out.println("Student"+(i+1)+" Marks:"+marks[i]);
        }
    }
}


public class StudentDetails
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the Numer of Students:");
        int n=sc.nextInt();
        sc.nextLine();

        Student1 s1=new Student1(n);
        s1.details(sc);
        s1.display();

    }
}
