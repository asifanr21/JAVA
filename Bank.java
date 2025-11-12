import java.util.Scanner;

class Account{
    String customerName;
    String accountNumber;
    String accountType;
    double balance;

    Account(String customerName, String accountNumber, String accountType, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    void displayBalance() {
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: ₹" + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

class SavAcct extends Account {
    private static final double INTEREST_RATE = 0.05; 

    SavAcct(String customerName, String accountNumber, double balance) {
        super(customerName, accountNumber, "Savings", balance);
    }

    void computeInterest(int years) {
        double interest = balance * Math.pow((1 + INTEREST_RATE), years) - balance;
        balance = balance + interest;
        System.out.printf("Interest of ₹%.2f added for %d year(s).\n", interest, years);
    }

    // @Override
    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

class CurAcct extends Account {
    private static final double MIN_BALANCE = 1000.0;
    private static final double SERVICE_CHARGE = 100.0;

    CurAcct(String customerName, String accountNumber, double balance) {
        super(customerName, accountNumber, "Current", balance);
    }

    // @Override
    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Check and impose penalty if below minimum balance
    void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Balance below minimum. Service charge of ₹" + SERVICE_CHARGE + " imposed.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = null;

        System.out.println("Welcome to the Bank System!");
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();
        System.out.print("Enter account type (savings/current): ");
        String type = sc.nextLine().toLowerCase();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        if (type.equals("savings")) {
            account = new SavAcct(customerName, accountNumber, balance);
        } else if (type.equals("current")) {
            account = new CurAcct(customerName, accountNumber, balance);
        } else {
            System.out.println("Invalid account type!");
            System.exit(0);
        }

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof SavAcct)
                System.out.println("4. Compute Interest");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double with = sc.nextDouble();
                    account.withdraw(with);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    if (account instanceof SavAcct) {
                        System.out.print("Enter number of years: ");
                        int years = sc.nextInt();
                        ((SavAcct) account).computeInterest(years);
                    } else {
                        System.out.println("Interest option only available for savings account.");
                    }
                    break;
                case 0:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
