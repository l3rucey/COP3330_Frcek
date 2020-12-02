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

    public ContactItem(String firstName, String lastName, String phoneNumber, String email) {
        if (!firstName.isBlank() || !lastName.isBlank() || !phoneNumber.isBlank() || !email.isBlank()) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.email = email;
        } else {
            System.out.println("ERROR: All entries cannot be blank");
        }
    }

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

    public String toString() {
        return(firstName + " " + lastName + " " + phoneNumber + " " + email);
    }

}

