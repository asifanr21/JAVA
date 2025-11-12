import java.util.Scanner;

class Book {
    private String B_Name;
    private String Author;
    private double price;
    private int Num_page;

    public Book(String B_Name, String Author, double price, int Num_page) {
        this.B_Name = B_Name;
        this.Author = Author;
        this.price = price;
        this.Num_page = Num_page;
    }

    // Getter methods
    public String getB_Name() { return B_Name; }
    public String getAuthor() { return Author; }
    public double getPrice() { return price; }
    public int getNum_page() { return Num_page; }

    // Setter methods
    public void setB_Name(String b_Name) { B_Name = b_Name; }
    public void setAuthor(String author) { Author = author; }
    public void setPrice(double price) { this.price = price; }
    public void setNum_page(int num_page) { Num_page = num_page; }

    @Override
    public String toString() {
        return "Book (B_Name=" + B_Name + ", Author=" + Author + ", price=" + price + ", Num_page=" + Num_page + ")";
    }
}

public class BookDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number of Books: ");
        int n = sc.nextInt();
        sc.nextLine();

        Book[] books = new Book[n];

        // Input book details using setters
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1));

            System.out.print("Book Name: ");
            String name = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Number of Pages: ");
            int pages = sc.nextInt();
            sc.nextLine();

            // Create Book object with default values
            books[i] = new Book("", "", 0, 0);

            // Set values using setters
            books[i].setB_Name(name);
            books[i].setAuthor(author);
            books[i].setPrice(price);
            books[i].setNum_page(pages);
        }

        System.out.println("\nDetails of All Books (using getters):");
        for (int i = 0; i < n; i++) {
            // Access fields using getters
            System.out.println(
                (i + 1) + " Book --> " +
                "Name: " + books[i].getB_Name() +
                ", Author: " + books[i].getAuthor() +
                ", Price: " + books[i].getPrice() +
                ", Pages: " + books[i].getNum_page()
            );
        }

        sc.close();
    }
}
