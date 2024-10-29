package org.example.commands;

import org.example.simpleClasses.Account;

public class ViewWeek extends Command{
    public ViewWeek(String name) {
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
