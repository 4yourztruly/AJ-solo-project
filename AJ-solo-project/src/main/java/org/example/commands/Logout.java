package org.example.commands;

import org.example.dependencies.Dependencies;
import org.example.simpleClasses.Account;

public class Logout extends Command{
    private final Dependencies dependencies;

    public Logout(String name, Dependencies dependencies) {
        super(name);
        this.dependencies = dependencies;
    }

    @Override
    public void execute(Account account) {
        System.out.println("Logging you out!");
        dependencies.getMenuManager().getMenu("Greet Menu").display();
    }

    @Override
    public String description() {
        return "Logout";
    }
}
