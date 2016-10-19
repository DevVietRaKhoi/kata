package fintech.processors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fintech.processors.AccountManager;

public class AccountManagerTest {

  private static final String TEST_NAME = "TEST_NAME";
  private static final String TEST_NAME_DUPLICATE = TEST_NAME.toLowerCase();
  private AccountManager accountManager;
  
  @Before
  public void setUp() {
    accountManager = new AccountManager();
  }
  
  @Test
  public void testAddAccount() {
    // Invalid input
    assertFalse(accountManager.addAccount(null, "1000"));
    assertFalse(accountManager.addAccount(TEST_NAME, TEST_NAME));
    assertFalse(accountManager.addAccount(TEST_NAME, "0.000"));
    assertFalse(accountManager.addAccount(TEST_NAME, "-1000"));
    
    // Success
    assertTrue(accountManager.addAccount(TEST_NAME, "1000"));
    
    // Duplicate
    assertFalse(accountManager.addAccount(TEST_NAME, "1000"));
    assertFalse(accountManager.addAccount(TEST_NAME_DUPLICATE, "1000"));
  }
  
  @Test
  public void testDeposit() {
    // Invalid input
    assertFalse(accountManager.depositForAccount(null, "1000"));
    assertFalse(accountManager.depositForAccount(TEST_NAME, TEST_NAME));
    assertFalse(accountManager.depositForAccount(TEST_NAME, "0.000"));
    assertFalse(accountManager.depositForAccount(TEST_NAME, "-1000"));
    
    // Non-existing account
    assertFalse(accountManager.depositForAccount(TEST_NAME, "1000"));
    
    // Add account
    assertTrue(accountManager.addAccount(TEST_NAME, "1000"));
    
    // Success
    assertTrue(accountManager.depositForAccount(TEST_NAME, "1000"));
  }
  
  @Test
  public void testWithdraw() {
    // Invalid input
    assertFalse(accountManager.withdrawFromAccount(null, "1000"));
    assertFalse(accountManager.withdrawFromAccount(TEST_NAME, TEST_NAME));
    assertFalse(accountManager.withdrawFromAccount(TEST_NAME, "0.000"));
    assertFalse(accountManager.withdrawFromAccount(TEST_NAME, "-1000"));
    
    // Non-existing account
    assertFalse(accountManager.withdrawFromAccount(TEST_NAME, "1000"));
    
    // Add account
    assertTrue(accountManager.addAccount(TEST_NAME, "1000"));
    
    // Insufficient
    assertFalse(accountManager.withdrawFromAccount(TEST_NAME, "2000"));
    
    // Success
    assertTrue(accountManager.withdrawFromAccount(TEST_NAME, "1000"));
  }
}
