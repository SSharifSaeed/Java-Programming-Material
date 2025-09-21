import java.util.Scanner;
public class BankAccount {

    // Declare the fields of the class
    private double balance;
    private double interestRate;
    private String ownerName;

    // Define the constructor of the class that takes three parameters
    public BankAccount(double balance, double interestRate, String ownerName) {
        // Assign the values of the parameters to the attributes
        this.balance = balance;
        this.interestRate = interestRate;
        this.ownerName = ownerName;
    }

    // Define a method to deposit money into the account
    public void deposit(double amount) {
        // Add the amount to the balance
        // Print a message to confirm the deposit
        balance += amount;
        System.out.println("you have deposited " + amount + " into your account.");
    }

    // Define a method to withdraw money from the account
    public void withdraw(double amount) {
        // Check if the amount is less than or equal to the balance
        if (amount <= balance) {
        // Subtract the amount from the balance
            balance -= amount;
        // Print a message to confirm the withdrawal
        System.out.println("You have withdrawn " + amount + "from your account");

        } else {
        // Print a message to indicate insufficient funds
        System.out.println("You have insufficient funds");

        }
    }

    // Define a method to transfer money from one account to another
    public void transfer(BankAccount other, double amount) {
        // Check if the amount is less than or equal to the balance
        if (amount <= balance) {
        // Subtract the amount from the balance of this account
            withdraw(amount);
        // Add the amount to the balance of the other account
            amount += other.balance;
        // Print a message to confirm the transfer
            System.out.println("You have transferred " + amount + " from your account to " + other.ownerName 
			+ "'s account.");
        } else {
        // Print a message to indicate insufficient funds
            System.out.println("You do not have enough money in your account.");
        }
    }

    // Define a method to display the information of the account
    public void display() {
        // Print the owner name, balance, and interest rate of the account
        System.out.println("Owner name: " + ownerName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest rate: " + interestRate);
    }



    public static void main(String[] args) {
        // Create an object called account1 with initial values
        Scanner scnr = new Scanner(System.in);
        BankAccount account1 = new BankAccount(1000, 0.5, "Alice");

        // Create another object called account2 with different values
        BankAccount account2 = new BankAccount(scnr.nextDouble(),(scnr.nextDouble())/100,"Bob");


        // Display the information of both accounts
        account1.display();
        account2.display();

        // Deposit 100 into account1
        account1.deposit(100);
        

        // Withdraw 200 from account2
        account2.withdraw(200);

        // Transfer 300 from account1 to account2
        account1.transfer(account2,300);

        // Display the information of both accounts again
        account1.display();
        account2.display();
    }
}




