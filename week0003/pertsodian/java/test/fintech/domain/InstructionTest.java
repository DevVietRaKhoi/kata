package fintech.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fintech.domain.Action;
import fintech.domain.Instruction;

public class InstructionTest {
  
  @Rule
  public ExpectedException expectedException = ExpectedException.none();
  
  @Test
  public void testInstruction_NullInput() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Invalid request");
    new Instruction(null);
  }
  
  @Test
  public void testInstruction_InvalidInput() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Invalid request");
    new Instruction("");
  }
  
  @Test
  public void testInstruction_InvalidAction() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Invalid request");
    new Instruction("Z Z Z");
  }
  
  @Test
  public void testInstruction() {
    verifyInstruction(new Instruction("A Z Z"), Action.ADD_ACCOUNT, "Z", "Z");
    verifyInstruction(new Instruction("D Z Z"), Action.DEPOSIT, "Z", "Z");
    verifyInstruction(new Instruction("W Z Z"), Action.WITHDRAW, "Z", "Z");
  }
  
  private void verifyInstruction(Instruction instruction, Action action, String accountName, String instructionDetail) {
    assertNotNull(instruction);
    assertEquals(action, instruction.getAction());
    assertEquals(accountName, instruction.getAccountName());
    assertEquals(instructionDetail, instruction.getInstructionDetail());
  }
}
