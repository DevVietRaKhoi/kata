package fintech.domain;

public class Instruction {
  
  private static final String DELIMITER = " ";
  private static final int INSTRUCTION_PARTS = 3;
  
  private final Action action;
  private final String accountName;
  private final String instructionDetail;
  
  public Instruction(String instruction) {
    if (instruction == null)
      throw new IllegalArgumentException("Invalid request");
    
    String[] parts = instruction.split(DELIMITER);
    if (parts.length != INSTRUCTION_PARTS)
      throw new IllegalArgumentException("Invalid request");
    
    action = Action.getAction(parts[0]);
    if (action == null)
      throw new IllegalArgumentException("Invalid request");
    
    accountName = parts[1];
    instructionDetail = parts[2];
  }
  
  public Action getAction() {
    return action;
  }
  
  public String getAccountName() {
    return accountName;
  }
  
  public String getInstructionDetail() {
    return instructionDetail;
  }
}
