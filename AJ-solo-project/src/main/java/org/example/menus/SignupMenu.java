package org.example.menus;

import org.example.dependencies.Dependencies;
import org.example.simpleClasses.Account;

import java.util.Scanner;

public class SignupMenu extends Menu{
    private final Scanner scanner = new Scanner(System.in);
    public SignupMenu(String name, Dependencies dependencies) {
        super(name, dependencies);
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        Account account = new Account(username,password);
        dependencies.getAccountManager().addAccount(account);
        System.out.println("Added " + account.getUsername());
        dependencies.getMenuManager().getMenu("Greet Menu").display();
    }
}
