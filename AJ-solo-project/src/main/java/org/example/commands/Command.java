package org.example.commands;

import org.example.account.Account;

public abstract class Command {
    String name;

    public Command(String name) {
        this.name = name;
    }

    public abstract void execute(Account account);

    public String getName(){
        return name;
    }
    public abstract String description();
}
