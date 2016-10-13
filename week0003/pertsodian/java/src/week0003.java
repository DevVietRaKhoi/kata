import java.util.Scanner;

import fintech.domain.Response;
import fintech.processors.AccountManager;
import fintech.processors.BankAccountApp;

public class week0003 {

  public static void main(String[] arg) {
    BankAccountApp bankAccountApp = createBankAccountApp();
    
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      Response response = bankAccountApp.processRequest(scanner.nextLine());
      System.out.println(response.getResponseMsg());
    }
    scanner.close();
  }
  
  public static BankAccountApp createBankAccountApp() {
    AccountManager accountManager = new AccountManager();
    return new BankAccountApp(accountManager);
  }
}
