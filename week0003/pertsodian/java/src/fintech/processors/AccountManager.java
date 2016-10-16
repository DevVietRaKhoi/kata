package fintech.processors;

import java.util.HashMap;
import java.util.Map;

import fintech.domain.Account;
import fintech.exceptions.InsufficientBalanceException;

public class AccountManager {

  private final Map<String, Account> accounts = new HashMap<>();

  public AccountManager() {
    this.accounts.clear();
  }

  public boolean addAccount(String name, String initialAmount) {
    try {
      Account existingAccount =
          accounts.putIfAbsent(getAccountKey(name), new Account(name, initialAmount));
      return existingAccount == null;
    }
    catch (IllegalArgumentException ex) {
      return false;
    }
  }

  public boolean depositForAccount(String name, String amount) {
    try {
      Account updatedAccount =
          accounts.computeIfPresent(
              getAccountKey(name),
              (key, account) -> {
                account.deposit(amount);
                return account;
              }
              );
      return updatedAccount != null;
    }
    catch (IllegalArgumentException ex) {
      return false;
    }
  }

  public boolean withdrawFromAccount(String name, String amount) {
    try {
      Account updatedAccount =
          accounts.computeIfPresent(
              getAccountKey(name),
              (key, account) -> {
                account.withdraw(amount);
                return account;
              }
              );
      return updatedAccount != null;
    }
    catch (IllegalArgumentException | InsufficientBalanceException ex) {
      return false;
    }
  }

  private String getAccountKey(String name) {
    if (name == null)
      throw new IllegalArgumentException("Invalid input name");
    return name.toUpperCase();
  }
}
