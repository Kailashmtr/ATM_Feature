import java.util.Scanner;

class ATM {
    private int balance;

    public ATM(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }
}

class BankAccount {
    private int accountBalance;

    public BankAccount(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void updateBalance(int amount) {
        accountBalance += amount;
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount(1000);
        ATM atm = new ATM(bankAccount.getAccountBalance());

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    int withdrawAmount = scanner.nextInt();
                    atm.withdraw(withdrawAmount);
                    bankAccount.updateBalance(-withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    int depositAmount = scanner.nextInt();
                    atm.deposit(depositAmount);
                    bankAccount.updateBalance(depositAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + atm.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
