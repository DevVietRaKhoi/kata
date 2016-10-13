package fintech.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Action {
  ADD_ACCOUNT("A"), DEPOSIT("D"), WITHDRAW("W");
  
  private String strValue;
  
  private Action(String strValue) {
    this.strValue = strValue;
  }
  
  public static Action getAction(String strValue) {
    Optional<Action> matchedAction = Arrays.stream(Action.values())
        .filter(action -> action.strValue.endsWith(strValue)).findAny();
    return matchedAction.isPresent() ? matchedAction.get() : null;
  }
}
