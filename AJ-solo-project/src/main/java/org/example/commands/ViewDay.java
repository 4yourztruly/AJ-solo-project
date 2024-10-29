package org.example.commands;

import org.example.simpleClasses.Account;

public class ViewDay extends Command{
    public ViewDay(String name) {
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
