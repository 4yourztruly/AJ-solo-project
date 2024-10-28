package org.example;

import org.example.account.Account;
import org.example.account.AccountManager;
import org.example.account.AccountManagerFile;
import org.example.account.Transaction;
import org.example.commands.*;
import org.example.menu.Menu;

import java.time.LocalDate;

public class Dependencies {
    private final AccountManager accountManager;
    private final CommandManager commandManager;

    public Dependencies() {
        this.accountManager = new AccountManagerFile();
        this.commandManager = new CommandListManager();
        Account account = new Account("tim","tim");
        accountManager.addAccount(account);
        Transaction transaction = new Transaction("item", 300, LocalDate.of(2002,12,10));
        account.addTransaction(transaction);
        ViewTransaction viewTransaction = new ViewTransaction("vt");
        commandManager.addCommand(viewTransaction);
        Transaction transaction1 = new Transaction("item2",500, LocalDate.of(2005, 12,9));
        account.addTransaction(transaction1);
        RemoveTransaction removeTransaction = new RemoveTransaction("rt");
        commandManager.addCommand(removeTransaction);
        AddTransaction addTransaction = new AddTransaction("at");
        commandManager.addCommand(addTransaction);
        Logout logout = new Logout("l",this);
        commandManager.addCommand(logout);
        Command help = new Command("help") {
            @Override
            public void execute(Account account) {
                for(Command command : commandManager.getCommands()) {
                    System.out.println(command.getName()+ " " + command.description());
                }
            }

            @Override
            public String description() {
                return "Help";
            }
        };
        commandManager.addCommand(help);
        Menu menu = new Menu(this);
        menu.greetMenu();


    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
}