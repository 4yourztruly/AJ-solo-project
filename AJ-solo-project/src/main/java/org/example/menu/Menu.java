package org.example.menu;


import org.example.account.Account;
import org.example.account.AccountManager;

import java.sql.SQLOutput;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner  = new Scanner(System.in);
    public static void greetMenu() {
        System.out.println();
        System.out.println("Hello welcome to Personal Finance!");
        System.out.println("Do you want to login or signup?");
        String greetInput = scanner.nextLine();
        if(!greetInput.equalsIgnoreCase("login") && !greetInput.equalsIgnoreCase("signup")) {
            System.out.println("Please enter login or signup");
            Menu.greetMenu();
        }

        if(greetInput.equalsIgnoreCase("login")) {
            Menu.loginMenu();
        }

        if(greetInput.equalsIgnoreCase("signup")) {
            Menu.signupMenu();
        }
    }

    public static void loginMenu() {
        System.out.println();
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        Optional<Account> optionalAccount =  AccountManager.findAccount(username,password);
        optionalAccount.ifPresentOrElse(
                account -> {
                    Menu.mainMenu(account);
                }, () -> System.out.println("Invalid username or password!")
        );
    }

    public static void signupMenu() {
        
    }

    public static void mainMenu(Account account) {
        System.out.println("Hello " + account.getUsername() + " Welcome to Personal Finance!");
        System.out.println("Your balance is " + account.getBalance() + "kr");
    }
}
