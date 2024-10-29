package org.example.menus;

import org.example.commands.Command;
import org.example.dependencies.Dependencies;
import org.example.simpleClasses.Account;

import java.util.Scanner;

public class MainMenu extends Menu{
    private final Scanner scanner = new Scanner(System.in);
    private final Account account;
    private boolean loggedIn;

    public MainMenu(String name, Dependencies dependencies, Account account, boolean loggedIn) {
        super(name, dependencies);
        this.account = account;
        this.loggedIn = loggedIn;
    }

    @Override
    public void display() {
        while(loggedIn) {
            System.out.println("Hello " + account.getUsername() + " Welcome to Personal Finance!");
            System.out.println("Your balance is " + account.getBalance() + "kr");
            System.out.println("Enter help for commands!");
            String commandInput = scanner.nextLine();

            for(Command command : dependencies.getCommandManager().getCommands()) {
                if(commandInput.equalsIgnoreCase(command.getName())){
                    if(commandInput.equalsIgnoreCase("l")){
                       loggedIn = false;
                    } command.execute(account);
                }
            }
        }
    }
}
