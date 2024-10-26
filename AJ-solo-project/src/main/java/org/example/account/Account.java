package org.example.account;

import java.util.ArrayList;

public class Account {
    private final String username;
    private final String password;
    private final ArrayList<Transaction>transactions = new ArrayList<>();
    private int balance;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        this.balance += transaction.getPrice();
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
        this.balance -= transaction.getPrice();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int balance) {
        this.balance += balance;
    }


}
