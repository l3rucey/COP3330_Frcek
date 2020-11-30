import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

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

    public void saveFile(String fileName) {
        try {
            Formatter file = new Formatter(fileName);
            for (ContactItem item: contactList) {
                file.format("%s %s %s %s%n",
                        item.getFirstName(),
                        item.getLastName(),
                        item.getEmail(),
                        item.getPhoneNumber());
            }
            file.close();
            System.out.println("task list has been saved");
        } catch (Exception ex) {
            System.out.println("u meeesxdfsdf upsadfasfd");
        }
        System.out.println("");
    }

    public void loadList(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            ArrayList<ContactItem> list = new ArrayList<ContactItem>();
            while(scan.hasNext()) {
                ContactItem temp = new ContactItem();
                temp.setFirstName(scan.next());
                temp.setLastName(scan.next());
                temp.setPhoneNumber(scan.next());
                temp.setEmail(scan.next());
                list.add(temp);
            }
            this.contactList = list;
            System.out.printf("contact list has been loaded%n%n");
        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist!");
        } catch (Exception ex) {
            System.out.println("what just happened!??");
        }
    }

    public ArrayList<ContactItem> getContactList() {
        return this.contactList;
    }
}
