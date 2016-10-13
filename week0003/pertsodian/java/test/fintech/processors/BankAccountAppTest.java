package fintech.processors;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import fintech.domain.Response;
import fintech.processors.AccountManager;
import fintech.processors.BankAccountApp;

public class BankAccountAppTest {

  private AccountManager accountManager;
  private BankAccountApp bankAccountApp;
  
  @Before
  public void setUp() {
    accountManager = Mockito.mock(AccountManager.class);
    Mockito.when(accountManager.addAccount(Mockito.any(), Mockito.any())).thenReturn(true);
    Mockito.when(accountManager.depositForAccount(Mockito.any(), Mockito.any())).thenReturn(true);
    Mockito.when(accountManager.withdrawFromAccount(Mockito.any(), Mockito.any())).thenReturn(false);
    
    bankAccountApp = new BankAccountApp(accountManager);
  }
  
  @Test
  public void testProcessRequest() {
    // INVALID request
    assertEquals(Response.INVALID, bankAccountApp.processRequest(null));
    assertEquals(Response.INVALID, bankAccountApp.processRequest(""));
    assertEquals(Response.INVALID, bankAccountApp.processRequest("Z Z Z"));
    
    // FAILED request
    assertEquals(Response.FAILED, bankAccountApp.processRequest("W Z Z"));
    
    // SUCCESSFUL request
    assertEquals(Response.SUCCESSFUL, bankAccountApp.processRequest("A Z Z"));
    assertEquals(Response.SUCCESSFUL, bankAccountApp.processRequest("D Z Z"));
  }
}
