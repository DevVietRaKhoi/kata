package event.management.domain;

public class Guest implements Comparable<Guest> {

  private static final String REGISTRATION_ENTRY_DELIMETER = ",";
  
  private String firstName;
  private String lastName;
  private String emailAddress;
  
  public Guest(String firstName, String lastName, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }
  
  public static Guest fromRegistrationEntry(String registrationEntry) {
    if (registrationEntry == null || registrationEntry.isEmpty())
      throw new IllegalArgumentException("Guest input is null or empty");
    
    String[] inputs = registrationEntry.split(REGISTRATION_ENTRY_DELIMETER);
    if (inputs.length != 3)
      throw new IllegalArgumentException("Invalid registration entry");
    
    return new Guest(inputs[0], inputs[1], inputs[2]);
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((emailAddress == null) ? 0 : emailAddress.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Guest other = (Guest) obj;
    if (emailAddress == null) {
      if (other.emailAddress != null)
        return false;
    } else if (!emailAddress.equals(other.emailAddress))
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    return true;
  }

  @Override
  public int compareTo(Guest another) {
    if (this.firstName.equals(another.firstName)) {
      if (this.lastName.equals(another.lastName))
        return this.emailAddress.compareTo(another.emailAddress);
      return this.lastName.compareTo(another.lastName);
    }
    return this.firstName.compareTo(another.firstName);
  }
}
