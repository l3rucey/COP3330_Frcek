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
            System.out.printf("%d) Name: %s %s%n Phone: %s%n Email: %s%n", i,
                        contactList.get(i).getFirstName(),
                        contactList.get(i).getLastName(),
                        contactList.get(i).getPhoneNumber(),
                        contactList.get(i).getEmail());
        }
        System.out.printf("%n");
    }

    public void addToList(String firstName, String lastName, String phoneNumber, String email) {
        ContactItem newContact = new ContactItem(firstName, lastName, phoneNumber, email);
        contactList.add(newContact);
//        try {
//            newContact.setFirstName(firstName);
//            newContact.setLastName(lastName);
//            newContact.setPhoneNumber(phoneNumber);
//            newContact.setEmail(email);
//            contactList.add(newContact);
//        } catch (IllegalArgumentException ex) {
//            System.out.println(ex.getMessage());
//        }
    }

    public void editList(int index, int size, String firstName, String lastName, String phoneNumber, String email) {
        //ContactItem temp = new ContactItem(firstName, lastName, phoneNumber, email);

        if (!firstName.isBlank() || !lastName.isBlank() || !phoneNumber.isBlank() || !email.isBlank()) {
            try {
                if (size == 0) {
                    throw new IllegalArgumentException("ERROR: No existing tasks");
                }
                if (index > size || index < 0) {
                    throw new IllegalArgumentException("ERROR: Choose an available index");
                }
                ContactItem temp = new ContactItem(firstName, lastName, phoneNumber, email);
//                temp.setFirstName(firstName);
//                temp.setLastName(lastName);
//                temp.setPhoneNumber(phoneNumber);
//                temp.setEmail(email);
                contactList.set(index, temp);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("ERROR: All entries cannot be left blank");
        }
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
                        item.getPhoneNumber(),
                        item.getEmail());
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
                String firstName;
                String lastName;
                String phoneNumber;
                String email;
                firstName = scan.next();
                lastName = scan.next();
                phoneNumber = scan.next();
                email = scan.next();
                ContactItem temp = new ContactItem(firstName, lastName, phoneNumber, email);
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
