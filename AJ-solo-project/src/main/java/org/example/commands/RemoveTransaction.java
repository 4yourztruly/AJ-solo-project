package org.example.commands;

import org.example.account.Account;
import org.example.account.Transaction;

import java.util.Scanner;

public class RemoveTransaction extends Command{
    Scanner scanner = new Scanner(System.in);

    public RemoveTransaction(String name) {
        super(name);
    }

    @Override
    public void execute(Account account) {
        System.out.println("Enter the name of the transaction: ");
        String name = scanner.nextLine();
        boolean itemexists = false;
        for(Transaction transaction : account.getTransactions()) {
            if(transaction.getName().equalsIgnoreCase(name)) {
                account.removeTransaction(transaction);
                System.out.println("Transaction removed! ");
                itemexists = true;
                break;
            }
        }
        if(!itemexists) {
            System.out.println("Item does not exist");
        }
    }
}
