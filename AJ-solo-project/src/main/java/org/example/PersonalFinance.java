package org.example;

import org.example.account.Account;
import org.example.account.AccountManager;
import org.example.menu.Menu;

public class PersonalFinance {
    public static void main(String[] args) {
        Account account = new Account("tim","tim");
        AccountManager.addAccount(account);
        Menu.greetMenu();
    }
}