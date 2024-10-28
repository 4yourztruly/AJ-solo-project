package org.example.commands;

import org.example.account.Account;
import org.example.account.Transaction;

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
        LocalDate newDate = LocalDate.parse(date);
        int newPrice = Integer.parseInt(price);
        Transaction transaction = new Transaction(name,newPrice,newDate);
        account.addTransaction(transaction);
        System.out.println("added " + transaction.getName());


    }

    @Override
    public String description() {
        return "Add Transaction";
    }
}
