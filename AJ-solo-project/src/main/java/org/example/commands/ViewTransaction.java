package org.example.commands;

import org.example.simpleClasses.Account;
import org.example.simpleClasses.Transaction;

public class ViewTransaction extends Command{

    public ViewTransaction(String name) {
        super(name);
    }

    @Override
    public void execute(Account account) {
        if(account.getTransactions().isEmpty()) {
            System.out.println("No transactions available!");
            return;
        }

        for(Transaction transaction : account.getTransactions()) {
            System.out.println(transaction.getName() + ", " + transaction.getPrice() + "kr" + ", " + transaction.getDate());
        }
    }

    @Override
    public String description() {
        return "View Transaction";
    }
}
