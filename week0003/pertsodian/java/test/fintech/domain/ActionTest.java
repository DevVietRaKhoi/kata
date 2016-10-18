package fintech.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import fintech.domain.Action;

public class ActionTest {

  @Test
  public void testGetAction() {
    assertEquals(Action.ADD_ACCOUNT, Action.getAction("A"));
    assertEquals(Action.DEPOSIT, Action.getAction("D"));
    assertEquals(Action.WITHDRAW, Action.getAction("W"));
    assertNull(Action.getAction("INVALID"));
  }
}
