package org.example.account;

import java.util.ArrayList;
import java.util.Optional;

public class AccountManagerFile implements AccountManager{
    private final ArrayList<Account> accounts = new ArrayList<>();

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
}
