package org.example.accountManager;

import org.example.simpleClasses.Account;

import java.util.ArrayList;
import java.util.Optional;

public interface AccountManager {
    void addAccount(Account account);
    void removeAccount(Account account);
    Optional<Account>findAccount (String username, String password);
    ArrayList<Account> getAccounts();
    void loadAccounts(ArrayList<Account> accounts);
}
