package fintech.domain;

public enum Response {
  SUCCESSFUL("True"), FAILED("False"), INVALID("Invalid");
  
  private String responseMsg;
  
  private Response(String responseMsg) {
    this.responseMsg = responseMsg;
  }
  
  public String getResponseMsg() {
    return responseMsg;
  }
}
