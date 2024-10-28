package org.example.account;

import java.util.Optional;

public interface AccountManager {
    void addAccount(Account account);
    void removeAccount(Account account);
    Optional<Account>findAccount (String username, String password);
}
