import java.util.Scanner;

class Shape{
    double radius;
    double length, breadth;
    double side1, side2, height;

    Scanner sc=new Scanner(System.in);

    void Circle(){
        System.out.print("Enter the Radius Of a Circle:");
        radius=sc.nextDouble();
        sc.nextLine();
    }

    void Rectangle(){
        System.out.print("Enter the Length of the reactangle:");
        length=sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter the Breadth of the RectAngle:");
        breadth=sc.nextDouble();
        sc.nextLine();
    }

    void Tripzuim(){
        System.out.print("Enter the Side 1:");
        side1=sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter the Side 2:");
        side2=sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter the Height:");
        height=sc.nextDouble();
        sc.nextLine();
    }

    double calCircle(){
        return 3.142*radius*radius;
    }

    double calRectangle(){
        return length*breadth;
    }

    double calTripzuim(){
        return 0.5*(side1+side2)*height;
    }
}

public class ShapeDemo{
    public static void main(String[] args){
        Shape s=new Shape();

        s.Circle();
        System.out.println("Area of the Circle:"+s.calCircle());

        s.Rectangle();
        System.out.println("Area of the RectAngle:"+s.calRectangle());

        s.Tripzuim();
        System.out.println("Area of the TripZuim:"+s.calTripzuim());
    }
}