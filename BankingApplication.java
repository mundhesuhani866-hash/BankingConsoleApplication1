
import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double balance = 10000.00;
        int choice;

        System.out.println("Welcome to Kiran Bank");
        System.out.println("Opening Balance: Rs. " + balance);

        while (true) {
            System.out.println("\n----- Banking Menu -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice. Enter 1, 2, 3 or 4.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();

            if (choice == 1) {
                System.out.printf("Current Balance: Rs. %.2f%n",
                                  balance);

            } else if (choice == 2) {
                System.out.print("Enter deposit amount: ");

                if (!sc.hasNextDouble()) {
                    System.out.println("Invalid amount.");
                    sc.nextLine();
                    continue;
                }

                double amount = sc.nextDouble();

                if (amount > 0 &&
                    Double.isFinite(amount) &&
                    balance + amount < Double.POSITIVE_INFINITY) {
                    balance += amount;
                    System.out.println("Deposit successful.");
                    System.out.printf("Updated Balance: Rs. %.2f%n",
                                      balance);
                } else {
                    System.out.println(
                        "Invalid deposit amount. Enter a positive amount.");
                }

            } else if (choice == 3) {
                System.out.print("Enter withdrawal amount: ");

                if (!sc.hasNextDouble()) {
                    System.out.println("Invalid amount.");
                    sc.nextLine();
                    continue;
                }

                double amount = sc.nextDouble();

                if (!Double.isFinite(amount) || amount <= 0) {
                    System.out.println(
                        "Invalid withdrawal amount. Enter a positive amount.");
                } else if (amount <= balance) {
                    balance -= amount;
                    System.out.println("Withdrawal successful.");
                    System.out.printf("Updated Balance: Rs. %.2f%n",
                                      balance);
                } else {
                    System.out.println(
                        "Transaction failed: Insufficient balance.");
                    System.out.printf("Current Balance: Rs. %.2f%n",
                                      balance);
                }

            } else if (choice == 4) {
                System.out.println(
                    "Thank you for banking with us. Goodbye!");
                break;

            } else {
                System.out.println(
                    "Invalid choice. Please select 1, 2, 3 or 4.");
            }
        }

        sc.close();
    }
}
