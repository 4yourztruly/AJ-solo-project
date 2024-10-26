package org.example.menu;

import org.example.account.Account;
import org.example.account.AccountManager;
import org.example.account.Transaction;

import java.time.LocalDate;
import java.util.Scanner;

public class Command {
    private static final Scanner scanner = new Scanner(System.in);

    public static void addTransaction(Account account) {
        System.out.println("Enter the name of the item: ");
        String name = scanner.nextLine();
        System.out.println("Enter the price of the item in numbers ex <30>: ");
        int price = scanner.nextInt();
        System.out.println("Enter the date in yyyy-mm-dd format: ");
        String date = scanner.nextLine();
        LocalDate convertedDate = LocalDate.parse(date);
        Transaction transaction = new Transaction(name,price,convertedDate);
        account.addTransaction(transaction);
    }

    public static void removeTransaction(Account account) {
        System.out.println("Enter the name of the transaction: ");
        String name = scanner.nextLine();
        boolean itemexists = false;
        for(Transaction transaction : account.getTransactions()) {
            if(transaction.getName().equalsIgnoreCase(name)) {
                account.removeTransaction(transaction);
                System.out.println("Transaction removed! ");
                itemexists = true;
            }
        }
        if(!itemexists) {
            System.out.println("Item does not exist");
        }
    }

    public static void viewTransactions(Account account) {
        for(Transaction transaction : account.getTransactions()) {
            System.out.println(transaction.getName() + transaction.getPrice() + transaction.getDate());
        }
    }

    public static void viewYear() {

    }

    public static void viewMonth() {

    }

    public static void viewWeek() {

    }

    public static void viewDay() {

    }

    public static void addBalance(Account account) {
        System.out.println("Enter the amount you want to add to your account: ");
        int balance = scanner.nextInt();
        account.addBalance(balance);
    }
}
