package org.example.commands;

import org.example.account.Account;
import org.example.account.Transaction;

public class ViewTransaction extends Command{

    public ViewTransaction(String name) {
        super(name);
    }

    @Override
    public void execute(Account account) {
        for(Transaction transaction : account.getTransactions()) {
            System.out.println(transaction.getName() + ", " + transaction.getPrice() + "kr" + ", " + transaction.getDate());
        }
    }
}
