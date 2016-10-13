package fintech.processors;

import fintech.domain.Instruction;
import fintech.domain.Response;

public class BankAccountApp {
  
  private final AccountManager accountManager;
  
  public BankAccountApp(AccountManager accountManager) {
    this.accountManager = accountManager;
  }
  
  public Response processRequest(String request) {
    Instruction instruction;
    try {
      instruction = new Instruction(request);
    }
    catch (IllegalArgumentException ex) {
      return Response.INVALID;
    }
    
    boolean result;
    switch (instruction.getAction()) {
      case ADD_ACCOUNT:
        result = accountManager.addAccount(instruction.getAccountName(), instruction.getInstructionDetail());
        break;
      case DEPOSIT:
        result = accountManager.depositForAccount(instruction.getAccountName(), instruction.getInstructionDetail());
        break;
      case WITHDRAW:
        result = accountManager.withdrawFromAccount(instruction.getAccountName(), instruction.getInstructionDetail());
        break;
      default:
        return Response.INVALID;
    }
    
    return result ? Response.SUCCESSFUL : Response.FAILED;
  }
}
