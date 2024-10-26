package org.example.account;

import java.util.ArrayList;
import java.util.Optional;

public class AccountManager {
    private static final ArrayList<Account> accounts = new ArrayList<>();

    public static void addAccount(Account account) {
        accounts.add(account);
    }

    public static void removeAccount(Account account) {
        accounts.remove(account);
    }

    public static Optional<Account> findAccount(String username, String password) {
        for(Account account: accounts) {
            if(account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return Optional.of(account);
            }
        }
        return Optional.empty();
    }
}
