package org.example.menu;


import org.example.Dependencies;
import org.example.account.Account;
import org.example.account.AccountManagerFile;
import org.example.commands.Command;

import java.util.Optional;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner  = new Scanner(System.in);
    private final Dependencies dependencies;

    public Menu(Dependencies dependencies) {
        this.dependencies = dependencies;
    }
    public void greetMenu() {
        System.out.println();
        System.out.println("Hello welcome to Personal Finance!");
        System.out.println("Do you want to login or signup?");
        String greetInput = scanner.nextLine();
        if(!greetInput.equalsIgnoreCase("login") && !greetInput.equalsIgnoreCase("signup")) {
            System.out.println("Please enter login or signup");
            this.greetMenu();
        }

        if(greetInput.equalsIgnoreCase("login")) {
            this.loginMenu();
        }

        if(greetInput.equalsIgnoreCase("signup")) {
            this.signupMenu();
        }
    }

    public void loginMenu() {
        System.out.println();
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        Optional<Account> optionalAccount =  dependencies.getAccountManager().findAccount(username,password);
        optionalAccount.ifPresentOrElse(
                account -> {
                    this.mainMenu(account);
                }, () -> System.out.println("Invalid username or password!")
        );
    }

    public void signupMenu() {
        System.out.println();
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        Account account = new Account(username,password);
        dependencies.getAccountManager().addAccount(account);
        System.out.println("Added " + account.getUsername());
        this.greetMenu();
    }

    public void mainMenu(Account account) {
        System.out.println("Hello " + account.getUsername() + " Welcome to Personal Finance!");
        System.out.println("Your balance is " + account.getBalance() + "kr");
        System.out.println("Enter help for commands!");
        String commandInput = scanner.nextLine();
        for(Command command : dependencies.getCommandManager().getCommands()) {
            if(commandInput.equalsIgnoreCase(command.getName())){
                command.execute(account);
                this.mainMenu(account);
            }
        }

    }
}
