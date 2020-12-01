import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {

    @Test
    public void addingItemsIncreasesSize() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Rob", "Jobs", "098-098-0889", "yo@gmail.com");
        int size = contactList.getContactList().size();
        assertEquals(1, size);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Rob", "Jobs", "980-098-0989", "itakeurjob@sorry.edu");
        contactList.editList(0, 1, "", "", "", "");
        assertEquals("Rob", contactList.getContactList().get(0).getFirstName());
        //assertThrows(IllegalAccessException.class, () -> contactList.editList(1, 2, "", "", "", "")); How do I do this?
    }

    // IF YOU CHANGE THE INDEX TO 1 IN THE EDIT LIST IT GIVES YOU AND OUTOFBOUNDS... BUT NOT WITH 2 OR MORE???
    @Test
    public void editingItemsFailsWithInvalidIndex() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Bob", "Jobs", "890-098-0989", "gmail.gmail.com");
        contactList.editList(3, 1,"Job", "Robs", "098-098-0800", "thisisanemail.org");
        assertEquals("Bob", contactList.getContactList().get(0).getFirstName());
    }

//      FIX THIS
    @Test
    public void editingSucceedsWithBlankFirstName () {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Bob", "Jobs", "980-098-0989", "sdfasd@gmail.com");
        contactList.editList(0, 1,"", "Billy", "893-098-0989", "yo@gmail.com");
        assertEquals("Billy", contactList.getContactList().get(0).getLastName());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Bob", "Jobs", "198-098-0980", "idonttakeurjob@allgood.edu");
        contactList.editList(0, 1,"Job", "", "190-098-0989", "thisisanemail.com");
        assertEquals("Job", contactList.getContactList().get(0).getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Bob", "Jobs", "098-098-0980", "idonttakeurjob@allgood.edu");
        contactList.editList(3, 1,"Job", "Robs", "", "what@gmail.com");
        assertEquals("Bob", contactList.getContactList().get(0).getFirstName());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Bob", "Jobs", "545-098-0989", "idonttakeurjob@allgood.edu");
        contactList.editList(0, 1,"Job", "Robs", "098-098-0989", "thisisanemail.org");
        assertEquals("Job", contactList.getContactList().get(0).getFirstName());
    }

    @Test
    public void newListIsEmpty() {
        ContactList contactList = new ContactList();
        contactList.createList();
        assertEquals(true, contactList.getContactList().isEmpty());
    }

    @Test
    public void removingItemsDecreasesSize() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Bob", "Jobs", "561-098-0998", "idonttakeurjob@allgood.edu");
        contactList.addToList("Rob", "Jobs", "562-098-0989", "urjob@allgood.edu");
        contactList.removeItem(0, 2);
        assertEquals(1, contactList.getContactList().size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Bob", "Jobs", "561-098-0989", "idonttakeurjob@allgood.edu");
        contactList.addToList("Rob", "Jobs", "562-098-0989", "urjob@allgood.edu");
        contactList.removeItem(3, 2);
        assertEquals(2, contactList.getContactList().size());
    }

    @Test
    public void savedContactListCanBeLoaded() {
        ContactList contactList = new ContactList();
        contactList.createList();
        contactList.addToList("Bob", "Jobs", "561-098-0989", "idonttakeurjob@allgood.edu");
        contactList.addToList("Rob", "Jobs", "562-098-0989", "urjob@allgood.edu");
        contactList.saveFile("contactList.txt");
        contactList.loadList("contactList.txt");
        assertEquals("Bob", contactList.getContactList().get(0).getFirstName());
    }

    // ------------------------------ //

    // THIS IS A WORKING EXTRA TEST CASE
//    @Test
//    public void editingItemsSucceedsWithValidIndex() {
//        ContactList contactList = new ContactList();
//        contactList.createList();
//        contactList.addToList("Bob", "Jobs", "idonttakeurjob@allgood.edu", "1-800-thanks-man");
//        contactList.editList(0, 1,"Job", "Robs", "thisisanemail.org", "1-800-098-0987");
//        assertEquals("Job", contactList.getContactList().get(0).getFirstName());
//    }

}
