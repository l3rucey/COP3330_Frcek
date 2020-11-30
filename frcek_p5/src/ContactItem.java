// Contains a "first name"
// Contains a "last name"
// Contains a "phone number"
// Contains a "email address"

// A contact item shall contain at least one of the above.

public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

