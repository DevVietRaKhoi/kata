package fin.tech.processors;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import fin.tech.domain.Account;
import fin.tech.exceptions.InsufficientBalanceException;

public class AccountManager {

  private final ConcurrentMap<String, Account> accounts = new ConcurrentHashMap<>();

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
  
  public BigDecimal getCurrentBalance(String name) {
    try {
      Account account = accounts.get(getAccountKey(name));
      return account != null ? account.getCurrentBalance() :  null;
    }
    catch (IllegalArgumentException ex) {
      return null;
    }
  }

  private String getAccountKey(String name) {
    if (name == null)
      throw new IllegalArgumentException("Invalid input name");
    return name.toUpperCase();
  }
}
