package org.example.commands;

import org.example.Dependencies;
import org.example.account.Account;
import org.example.menu.Menu;

public class Logout extends Command{
    Dependencies dependencies;

    public Logout(String name, Dependencies dependencies) {
        super(name);
        this.dependencies = dependencies;
    }

    @Override
    public void execute(Account account) {
        System.out.println("Logging you out!");
        Menu menu = new Menu(dependencies);
        menu.greetMenu();
    }

    @Override
    public String description() {
        return "Logout";
    }
}
