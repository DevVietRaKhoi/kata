package fintech.domain;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;

import fintech.exceptions.InsufficientBalanceException;

public class Account {

  private final String name;
  private BigDecimal balanceAmount;
  private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  
  public Account(String name, String initialAmount) {
    if (name == null)
      throw new IllegalArgumentException("Invalid input name");
    this.name = name;
    this.balanceAmount = parseAmount(initialAmount);
  }
  
  public String getName() {
    return name;
  }

  public BigDecimal getCurrentBalance() {
    try {
      lock.readLock().lock();
      return balanceAmount;
    }
    finally {
      lock.readLock().unlock();
    }
  }
  
  public void deposit(String amount) {
    executeInWriteLock(account -> account.adjustBalance(parseAmount(amount)));
  }
  
  public void withdraw(String amount) {
    executeInWriteLock(account -> account.adjustBalance(parseAmount(amount).negate()));
  }
  
  private void adjustBalance(BigDecimal amount) {
    BigDecimal adjustedBalance = balanceAmount.add(amount);
    if (adjustedBalance.compareTo(BigDecimal.ZERO) < 0)
      throw new InsufficientBalanceException();
    balanceAmount = adjustedBalance; 
  }
  
  protected void executeInWriteLock(Consumer<Account> consumer) {
    try {
      lock.writeLock().lock();
      consumer.accept(this);
    }
    finally {
      lock.writeLock().unlock();
    }
  }

  protected BigDecimal parseAmount(String amountStr) {
    try {
      BigDecimal amount = new BigDecimal(amountStr);
      if (isNegative(amount))
        throw new IllegalArgumentException("Amount must be positive");
      return amount;
    }
    catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid input amount");
    }
  }
  
  private boolean isNegative(BigDecimal amount) {
    return amount.compareTo(BigDecimal.ZERO) <= 0;
  }
}
