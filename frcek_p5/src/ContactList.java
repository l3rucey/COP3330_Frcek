import java.util.ArrayList;

public class ContactList {
    private ArrayList<ContactItem> contactList;

    public void createList() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        System.out.printf("new contact list has been created%n%n");
        this.contactList = list;
    }

    public void viewList() {
        int size = contactList.size();
        System.out.printf("Current Contacts%n-------------%n%n");
        for (int i = 0; i < size; i++) {
//            if(itemList.get(i).getMark()) {
//                System.out.printf("*** %d) [%s] %s: %s%n", i,
//                        itemList.get(i).getDate(),
//                        itemList.get(i).getTitle(),
//                        itemList.get(i).getDescription());
//            } else {
//                System.out.printf("%d) [%s] %s: %s%n", i,
//                        itemList.get(i).getDate(),
//                        itemList.get(i).getTitle(),
//                        itemList.get(i).getDescription());
//            }
            System.out.printf("%d) Name: %s%n Phone: %s%n Email: %s%n PhoneNumber %s%n", i,
                        contactList.get(i).getFirstName(),
                        contactList.get(i).getLastName(),
                        contactList.get(i).getEmail(),
                        contactList.get(i).getPhoneNumber());
        }
        System.out.printf("%n");
    }

    public void addToList(String firstName, String lastName, String email, String phoneNumber) {
        ContactItem newContact = new ContactItem();
        try {
//            if(title.length() < 1) {
//                throw new IllegalArgumentException("ERROR: A title needs to be 1 or more characters in length");
//            }
            newContact.setFirstName(firstName);
            newContact.setLastName(lastName);
//            // didn't have time to do full validation
//            if(date.length() != 10) {
//                throw new IllegalArgumentException("ERROR: A due date needs to be in the format of YYYY-MM-DD");
//            }
            newContact.setEmail(email);
            newContact.setPhoneNumber(phoneNumber);
            contactList.add(newContact);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void editList(int index, int size, String firstName, String lastName, String email, String phoneNumber) {
        ContactItem temp = new ContactItem();

        if (!firstName.isBlank() && !lastName.isBlank() && !email.isBlank() && !phoneNumber.isBlank()) {
            try {
                if (size == 0) {
                    throw new IllegalArgumentException("ERROR: No existing tasks");
                }
                if (index > size || index < 0) {
                    throw new IllegalArgumentException("ERROR: Choose an available index");
                }
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setEmail(email);
                temp.setPhoneNumber(phoneNumber);
                contactList.set(index, temp);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("ERROR: All entries cannot be left blank");
    }

    public void removeItem(int index, int size) {
        try {
            if (size == 0) {
                throw new IllegalArgumentException("ERROR: No existing tasks");
            }
            if(index > size || index < 0) {
                throw new IllegalArgumentException("ERROR: Choose an available index");
            }
            contactList.remove(index);
        } catch (Exception ex) {
            System.out.println("Enter proper index or no tasks available to remove");
        }
    }

    public ArrayList<ContactItem> getContactList() {
        return this.contactList;
    }
}
