import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues() {
        ContactItem contactItem = new ContactItem("", "", "", "");
        assertEquals(null, contactItem.getFirstName());
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        ContactItem contactItem = new ContactItem("Bob", "Billy", "908-098-0989", "");
        assertEquals("Bob", contactItem.getFirstName());
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        ContactItem contactItem = new ContactItem("", "Billy", "908-098-0989", "what@gmail.com");
        assertEquals("Billy", contactItem.getLastName());
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        ContactItem contactItem = new ContactItem("Bob", "", "908-098-0989", "what@gmail.com");
        assertEquals("Bob", contactItem.getFirstName());
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        ContactItem contactItem = new ContactItem("Bob", "Billy", "", "what@gmail.com");
        assertEquals("Bob", contactItem.getFirstName());
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        ContactItem contactItem = new ContactItem("Bob", "Billy", "908-098-0989", "what@gmail.com");
        assertEquals("Bob", contactItem.getFirstName());
    }

    // check later too see if you need to switch this to a contactItem... but how would you then access the edit method?
    @Test
    public void editingFailsWithAllBlankValues() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Bob", "Billy", "561-098-0989", "what@gmail.com");
        contactList.editList(0, 1, "", "", "", "");
        assertEquals("Bob", contactList.getContactList().get(0).getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Bob", "Billy", "561-098-0989", "what@gmail.com");
        contactList.editList(0, 1, "Dan", "Don", "098-098-0989", "");
        assertEquals("Dan", contactList.getContactList().get(0).getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Bob", "Billy", "561-098-0989", "what@gmail.com");
        contactList.editList(0, 1, "", "Don", "098-098-0989", "ya@gmail.com");
        assertEquals("Don", contactList.getContactList().get(0).getLastName());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Bob", "Billy", "561-098-0989", "what@gmail.com");
        contactList.editList(0, 1, "Dan", "", "098-098-0989", "ya@gmail.com");
        assertEquals("Dan", contactList.getContactList().get(0).getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Bob", "Billy", "561-098-0989", "what@gmail.com");
        contactList.editList(0, 1, "Dan", "Don", "", "ya@gmail.com");
        assertEquals("Dan", contactList.getContactList().get(0).getFirstName());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Bob", "Billy", "561-098-0989", "what@gmail.com");
        contactList.editList(0, 1, "Dan", "Don", "561-433-0989", "ya@gmail.com");
        assertEquals("Dan", contactList.getContactList().get(0).getFirstName());
    }

    @Test
    public void testToString() {
        ContactItem contactItem = new ContactItem("Bob", "Billy", "908-098-0989", "what@gmail.com");
        contactItem.toString();
        assertEquals("Bob", contactItem.getFirstName());
    }
}
