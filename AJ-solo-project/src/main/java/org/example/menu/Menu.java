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
        System.out.println();
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        Account account = new Account(username,password);
        AccountManager.addAccount(account);
        System.out.println("Added " + account.getUsername());
        Menu.greetMenu();
    }

    public static void mainMenu(Account account) {
        System.out.println("Hello " + account.getUsername() + " Welcome to Personal Finance!");
        System.out.println("Your balance is " + account.getBalance() + "kr");
        System.out.println("Enter help for commands!");
        String command = scanner.nextLine();
        if(command.equalsIgnoreCase("help")) {
            System.out.println("View transactions = vt, add transactions = at, remove transaction = rt, view history in year, month, week or day = vy, vm, vw, vd, Add balance = ab, Logout = logout");
        }

        if(command.equalsIgnoreCase("vt")) {
            Command.viewTransactions(account);
        }

        if(command.equalsIgnoreCase("at")) {
            Command.addTransaction(account);
        }

        if(command.equalsIgnoreCase("rt")) {
            Command.removeTransaction(account);
        }

        if(command.equalsIgnoreCase("vy")) {
            Command.viewYear();
        }

        if(command.equalsIgnoreCase("vm")) {
            Command.viewMonth();
        }

        if(command.equalsIgnoreCase("vw")) {
            Command.viewWeek();
        }

        if(command.equalsIgnoreCase("vd")) {
            Command.viewDay();
        }

        if(command.equalsIgnoreCase("ab")) {
            Command.addBalance(account);
        }

        if(command.equalsIgnoreCase("logout")) {
            System.out.println("Logging you out!");
            greetMenu();
        }
    }
}
