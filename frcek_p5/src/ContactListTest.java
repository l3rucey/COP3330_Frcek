import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {

    @Test
    public void addingItemsIncreasesSize() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Rob", "Jobs", "itakeurjob@sorry.edu", "1-800-sorry-bro");
        int size = contactList.getContactList().size();
        assertEquals(1, size);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.editList(2, 3, "1", "", "", "");


    }

//    @Test
//    public void editingItemsFailsWithInvalidIndex() {
//        ContactList contactList = new ContactList();
//        contactList.createList();
//        contactList.addToList();
//    }
}
