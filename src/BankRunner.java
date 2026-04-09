import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankRunner {
    private static Map<String, Account> database = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("-----------please choose your statement----------");
        while (true) {
            printMainMenu();
            int choice = getintinput();
            switch (choice) {
                case 1 -> createAccount();
                case 2 -> performDeposit();
                case 3 -> performWithdraw();
                case 4 -> checkHistory();
                case 5 -> {
                    System.out.println("Thank you for banking with us. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. please enter a valid choice");

            }
        }


    }
    private static void printMainMenu() {
        System.out.println("\n1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transaction History");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }



    private static void createAccount() {
        System.out.print("Enter Account Number: ");
        String id = scanner.next();
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.next();
        System.out.print("Initial Deposit: ");
        double amount = scanner.nextDouble();

        Account newAcc = new Account(id, name, amount);
        database.put(id, newAcc);
        System.out.println("Account created successfully!");
    }

    private static void performDeposit(){

        Account acc = findAccount();
        if(acc!=null){
            System.out.println("enter the amount to deposit");
            double amount = scanner.nextDouble();
            acc.deposit()

        }
    }


}



