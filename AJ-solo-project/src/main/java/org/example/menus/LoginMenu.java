package org.example.menus;

import org.example.dependencies.Dependencies;
import org.example.simpleClasses.Account;

import java.util.Optional;
import java.util.Scanner;

public class LoginMenu extends Menu{
    private final Scanner scanner = new Scanner(System.in);
    private boolean loggedIn = false;
    public LoginMenu(String name, Dependencies dependencies) {
        super(name, dependencies);
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        Optional<Account> optionalAccount =  dependencies.getAccountManager().findAccount(username,password);
        optionalAccount.ifPresentOrElse(
                account -> {
                    loggedIn = true;
                    MainMenu mainMenu = new MainMenu("Main Menu",dependencies, account,loggedIn);
                    dependencies.getMenuManager().addMenu(mainMenu);
                    mainMenu.display();
                }, () -> {
                    System.out.println("Invalid username or password!");
                    loggedIn = false;
                    dependencies.getMenuManager().getMenu("Greet Menu").display();
                }
        );
    }
}
