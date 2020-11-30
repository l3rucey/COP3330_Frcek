import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {

    public void menuStart() {
        ContactList contactList = new ContactList(); // instantiation of a ContactList
        Scanner input = new Scanner(System.in);
        while (true) {
            mainMenu();
            int mainMenuAnswer = getUserInput();
            if (mainMenuAnswer == 1) {
                contactList.createList();
                while (true) {
                    opMenu();
                    int opMenuAnswer = getUserInput();
                    //int opMenuAnswer = input.nextInt();
                    if (opMenuAnswer == 1) {
                        contactList.viewList();
                    } else if (opMenuAnswer == 2) {
                        _addToList(contactList);
                    } else if (opMenuAnswer == 3) {
                        contactList.viewList();
                        _editList(contactList);
                    } else if (opMenuAnswer == 4) {
                        contactList.viewList();
                        _removeItem(contactList);
                    } else if (opMenuAnswer == 5) {
                        _saveFile(contactList);
                    } else if (opMenuAnswer == 6) {
                        break;
                    } else {
                        System.out.println("ERROR! Enter an integer value between [1-8] inclusive");
                    }
                }
            } else if (mainMenuAnswer == 2) {
                _loadList(contactList);
                while (true) {
                    opMenu();
                    int opMenuAnswer = getUserInput();
                    //int opMenuAnswer = input.nextInt();
                    if (opMenuAnswer == 1) {
                        contactList.viewList();
                    } else if (opMenuAnswer == 2) {
                        _addToList(contactList);
                    } else if (opMenuAnswer == 3) {
                        contactList.viewList();
                        _editList(contactList);
                    } else if (opMenuAnswer == 4) {
                        contactList.viewList();
                        _removeItem(contactList);
                    } else if (opMenuAnswer == 5) {
                        _saveFile(contactList);
                    } else if (opMenuAnswer == 6) {
                        break;
                    } else {
                        System.out.println("ERROR! Enter an integer value between [1-6] inclusive");
                    }
                }
            } else {
                System.exit(0); // be careful
            }
        }
    }

    private static void mainMenu() {
        System.out.printf("Main Menu%n---------%n%n" +
                "1) create a new list%n" +
                "2) load an existing list%n" +
                "3) quit%n%n");
    }

    private static int getUserInput() {
        Scanner input = new Scanner(System.in);
        boolean repeat = true;
        int answer = 0;

        while (repeat) {
            try {
                answer = input.nextInt();
                repeat = false;
            } catch (InputMismatchException ex) {
                System.out.println("ERROR: You must enter an integer");
                input.nextLine();
                repeat = true;
            }
        }
        return answer;
    }

    private static void opMenu() {
        System.out.printf("%nList Operation Menu%n-------------------%n%n" +
                "1) view the list%n" +
                "2) add an item%n" +
                "3) edit an item%n" +
                "4) remove an item%n" +
                "5) save the current list%n" +
                "6) quit to the main menu%n%n");
    }

    private static void _addToList(ContactList list) {
        //TaskItem newTask = new TaskItem(); dont need
        Scanner input = new Scanner(System.in);

        String firstName;
        String lastName;
        String phoneNumber;
        String email;

        System.out.print("First name: ");
        firstName = input.nextLine();
        System.out.print("Last name: ");
        lastName = input.nextLine();
        System.out.print("Phone number (xxx-xxx-xxxx): ");
        phoneNumber = input.nextLine();
        System.out.println("Email address: ");
        email = input.nextLine();

        list.addToList(firstName, lastName, phoneNumber, email);
    }

    private static void _editList(ContactList list) {
        try {
            Scanner scan = new Scanner(System.in);
            int index;
            String firstName;
            String lastName;
            String phoneNumber;
            String email;
            System.out.print("Which contact will you edit? ");
            index = scan.nextInt();
            scan.nextLine(); // for buffer i think.
            System.out.printf("Enter a new first name for contact %d: ", index);
            firstName = scan.nextLine();
            System.out.printf("Enter a new last name for contact %d: ", index);
            lastName = scan.nextLine();
            System.out.printf("Enter a new phone number (xxx-xx-xxxx) for contact %d: ", index);
            phoneNumber = scan.nextLine();
            System.out.printf("Enter a new email (x@y.z) for contact %d: ", index);
            email = scan.nextLine();

            list.editList(index, list.getContactList().size(), firstName, lastName, phoneNumber, email);

        } catch (Exception ex) {
            System.out.println("ERROR: Ill add an actual msg here soon");
        }
    }

    // change to name to "removeContact".
    private static void _removeItem(ContactList list) {
        int index;
        int size = list.getContactList().size();
        Scanner input = new Scanner(System.in);
        System.out.print("Which contact will you remove? ");
        index = input.nextInt();
        input.nextLine();

        list.removeItem(index, size);
    }

    private static void _saveFile(ContactList list) {
        String fileName;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename to save as: ");
        fileName = input.nextLine();
        list.saveFile(fileName);
    }


    // change param to contactList
    private static void _loadList(ContactList list) {
        Scanner input = new Scanner(System.in);
        String fileName;
        System.out.print("Enter the filename to load: ");
        fileName = input.nextLine();
        list.loadList(fileName);
    }


}
