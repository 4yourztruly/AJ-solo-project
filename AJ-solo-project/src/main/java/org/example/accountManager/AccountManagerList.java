package org.example.accountManager;

import org.example.simpleClasses.Account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

public class AccountManagerList implements AccountManager, Serializable {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public Optional<Account> findAccount(String username, String password) {
        for(Account account: accounts) {
            if(account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return Optional.of(account);
            }
        }
        return Optional.empty();
    }

    @Override
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    @Override
    public void loadAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
}
