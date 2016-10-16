package fintech.domain;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fintech.domain.Account;
import fintech.exceptions.InsufficientBalanceException;

public class AccountTest {

  private static final String TEST_NAME = "TEST_NAME";
  
  @Rule
  public ExpectedException expectedException = ExpectedException.none();
  
  @Test
  public void testAccountInit() {
    Account account = new Account(TEST_NAME, "1000");
    assertEquals(TEST_NAME, account.getName());
    assertEquals(new BigDecimal("1000"), account.getCurrentBalance());
  }
  
  @Test
  public void testAccountInit_NullName() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Invalid input name");
    new Account(null, "1000");
  }
  
  @Test
  public void testAccountInit_NonNumericInitialAmount() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Invalid input amount");
    new Account(TEST_NAME, TEST_NAME);
  }
  
  @Test
  public void testAccountInit_NegativeInitialAmount() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Amount must be positive");
    new Account(TEST_NAME, "-1000");
  }
  
  @Test
  public void testAccountInit_ZeroInitialAmount() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Amount must be positive");
    new Account(TEST_NAME, "0.000000");
  }
  
  @Test
  public void testDeposit() {
    Account account = new Account(TEST_NAME, "1000");
    account.deposit("500");
    
    assertEquals(TEST_NAME, account.getName());
    assertEquals(new BigDecimal("1500"), account.getCurrentBalance());
  }
  
  @Test
  public void testDeposit_NonNumericAmount() {
    Account account = new Account(TEST_NAME, "1000");
    
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Invalid input amount");
    account.deposit(TEST_NAME);
  }
  
  @Test
  public void testDeposit_NegativeAmount() {
    Account account = new Account(TEST_NAME, "1000");
    
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Amount must be positive");
    account.deposit("-500");
  }
  
  @Test
  public void testDeposit_ZeroAmount() {
    Account account = new Account(TEST_NAME, "1000");
    
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Amount must be positive");
    account.deposit("0.000");
  }
  
  @Test
  public void testWithdraw() throws InsufficientBalanceException {
    Account account = new Account(TEST_NAME, "1000");
    account.withdraw("500");
    
    assertEquals(TEST_NAME, account.getName());
    assertEquals(new BigDecimal("500"), account.getCurrentBalance());
  }
  
  @Test
  public void testWithdraw_NonNumericAmount() throws InsufficientBalanceException {
    Account account = new Account(TEST_NAME, "1000");
    
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Invalid input amount");
    account.withdraw(TEST_NAME);
  }
  
  @Test
  public void testWithdraw_NegativeAmount() throws InsufficientBalanceException {
    Account account = new Account(TEST_NAME, "1000");
    
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Amount must be positive");
    account.withdraw("-500");
  }
  
  @Test
  public void testWithdraw_ZeroAmount() throws InsufficientBalanceException {
    Account account = new Account(TEST_NAME, "1000");
    
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Amount must be positive");
    account.withdraw("0.000");
  }
  
  @Test
  public void testWithdraw_InsufficientBalance() throws InsufficientBalanceException {
    Account account = new Account(TEST_NAME, "1000");

    expectedException.expect(InsufficientBalanceException.class);
    account.withdraw("1500");
  }
}
