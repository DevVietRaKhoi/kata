import java.util.Scanner;

import fin.tech.domain.Response;
import fin.tech.processors.AccountManager;
import fin.tech.processors.BankAccountApp;

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
