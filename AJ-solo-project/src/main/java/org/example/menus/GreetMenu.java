package org.example.menus;

import org.example.dependencies.Dependencies;

import java.util.Scanner;

public class GreetMenu extends Menu{
    private final Scanner scanner = new Scanner(System.in);
    public GreetMenu(String name, Dependencies dependencies) {
        super(name, dependencies);
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println("Hello welcome to Personal Finance!");
        System.out.println("Do you want to login, signup or exit?");
        String greetInput = scanner.nextLine();
        if(!greetInput.equalsIgnoreCase("login") && !greetInput.equalsIgnoreCase("signup") && !greetInput.equalsIgnoreCase("exit")) {
            System.out.println("Please enter login, signup or exit");
            display();
        }

        if(greetInput.equalsIgnoreCase("login")) {
            dependencies.getMenuManager().getMenu("Login Menu").display();
        }

        if(greetInput.equalsIgnoreCase("signup")) {
            dependencies.getMenuManager().getMenu("Signup Menu").display();
        }

        if(greetInput.equalsIgnoreCase("exit")) {
            System.out.println("Exiting!");
        }
    }
}
