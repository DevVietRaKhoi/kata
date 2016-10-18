package fintech.domain;

import java.math.BigDecimal;

import fintech.exceptions.InsufficientBalanceException;

public class Account {

  private final String name;
  private BigDecimal balanceAmount;
  
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
    return balanceAmount;
  }
  
  public void deposit(String amount) {
    adjustBalance(parseAmount(amount));
  }
  
  public void withdraw(String amount) {
    adjustBalance(parseAmount(amount).negate());
  }
  
  private void adjustBalance(BigDecimal amount) {
    BigDecimal adjustedBalance = balanceAmount.add(amount);
    if (adjustedBalance.compareTo(BigDecimal.ZERO) < 0)
      throw new InsufficientBalanceException();
    balanceAmount = adjustedBalance; 
  }

  private BigDecimal parseAmount(String amountStr) {
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
