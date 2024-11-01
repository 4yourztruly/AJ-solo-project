package org.example.commands;

import org.example.simpleClasses.Account;
import org.example.simpleClasses.Transaction;

import java.time.LocalDate;
import java.util.Scanner;

public class AddTransaction extends Command{
    Scanner scanner = new Scanner(System.in);
    public AddTransaction(String name) {
        super(name);
    }

    @Override
    public void execute(Account account) {
        System.out.println("Enter name of item: ");
        String name = scanner.nextLine();
        System.out.println("Enter price of item: ");
        String price = scanner.nextLine();
        System.out.println("Enter date of purchase in format yyyy-mm-dd: ");
        String date = scanner.nextLine();
        LocalDate newDate = null;
        try {
            newDate = LocalDate.parse(date);
        } catch (Exception e) {
            System.out.println("Please enter a date in the correct format!");
            return;
        }
        int newPrice = 0;
        try {
            newPrice = Integer.parseInt(price);
        } catch (Exception e) {
            System.out.println("Please enter a number as the price!");
            return;
        }

        Transaction transaction = new Transaction(name,newPrice,newDate);
        account.addTransaction(transaction);
        System.out.println("added " + transaction.getName());


    }

    @Override
    public String description() {
        return "Add Transaction";
    }
}
