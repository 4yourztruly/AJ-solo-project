package org.example.commands;

import org.example.simpleClasses.Account;

public class ViewMonth extends Command{
    public ViewMonth(String name) {
        super(name);
    }

    @Override
    public void execute(Account account) {

    }

    @Override
    public String description() {
        return "";
    }
}
