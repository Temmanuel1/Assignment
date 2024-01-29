package entities.all;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class BankApplication {
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, Double> balances = new HashMap<>();

    public static void main(String[] args) {
        initializeUsers();
        login();
    }

    private static void initializeUsers() {
        // Initialize some users and their balances
        users.put("Emmy", "123");
        balances.put("Emmy B", 1000.0);

        users.put("Vicky", "123");
        balances.put("Vicky T", 1500.0);
        
        users.put("Alice", "123");
        balances.put("Alice U", 3000.0);
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bank of Kigali(BK)");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (authenticateUser(username, password)) {
            displayMenu(username);
        } else {
            System.out.println("Invalid username or password. Please try again.");
            login();
        }
    }

    private static boolean authenticateUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    private static void displayMenu(String username) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWelcome, " + username + "!");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance(username);
                    break;
                case 2:
                    withdraw(username);
                    break;
                case 3:
                    deposit(username);
                    break;
                case 4:
                    System.out.println("Thank you for using the Bank Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

    private static void checkBalance(String username) {
        System.out.println("Your balance: $" + balances.get(username));
    }

    private static void withdraw(String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balances.get(username)) {
            balances.put(username, balances.get(username) - amount);
            System.out.println("Withdrawal successful. Your new balance: $" + balances.get(username));
        } else {
            System.out.println("Invalid amount or insufficient funds. Withdrawal failed.");
        }
    }

    private static void deposit(String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balances.put(username, balances.get(username) + amount);
            System.out.println("Deposit successful. Your new balance: $" + balances.get(username));
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }
}

