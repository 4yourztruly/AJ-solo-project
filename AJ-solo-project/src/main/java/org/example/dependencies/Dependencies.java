package org.example.dependencies;

import org.example.menuManager.MenuManager;
import org.example.menuManager.MenuManagerList;
import org.example.menus.*;
import org.example.save.Save;
import org.example.save.SaveToFile;
import org.example.simpleClasses.Account;
import org.example.accountManager.AccountManager;
import org.example.accountManager.AccountManagerList;
import org.example.simpleClasses.Transaction;
import org.example.commandManager.CommandListManager;
import org.example.commandManager.CommandManager;
import org.example.commands.*;

import javax.swing.text.View;
import java.io.IOException;
import java.time.LocalDate;

public class Dependencies {
    private final AccountManager accountManager;
    private final CommandManager commandManager;
    private final MenuManager menuManager;
    private final Save save;

    public Dependencies() {
        this.accountManager = new AccountManagerList();
        this.commandManager = new CommandListManager();
        this.menuManager = new MenuManagerList();
        this.save = new SaveToFile(this);

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
        ViewYear viewYear = new ViewYear("vy");
        commandManager.addCommand(viewYear);

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
        GreetMenu greetMenu = new GreetMenu("Greet Menu", this);
        LoginMenu loginMenu = new LoginMenu("Login Menu", this);
        SignupMenu signupMenu = new SignupMenu("Signup Menu", this);
        menuManager.addMenu(greetMenu);
        menuManager.addMenu(loginMenu);
        menuManager.addMenu(signupMenu);
        save.load();
        menuManager.getMenu("Greet Menu").display();
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public MenuManager getMenuManager() {
        return menuManager;
    }

    public Save getSaveFile() {
        return save;
    }
}
