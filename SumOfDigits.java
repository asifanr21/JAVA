import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number : ");
        int n=sc.nextInt();
        sc.nextLine();

        int temp=0;
        for(int i=0; i<=n; i++){
            temp=temp+i;
        }

        System.out.println("Sum of given Number : "+temp);
    }
}
