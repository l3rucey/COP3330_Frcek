import java.io.FileNotFoundException;
import java.util.Formatter;

// Handles interaction with user

// User should be able to do the following
//      Create a new tasklist
//      load an existing tasklist
//      view the current tasklist
//      etc.
public class App {
    public static void main(String[] args) {
        // Pseudocode
        // Create a UI menu for the user
        // Create function that can cycle through the user options
        //      and envoke the functions in TaskList appropriately

        TaskList l = new TaskList();
        l.createList();
        l.addToList();
        l.viewList();

        //TaskList l = new TaskList();
        //l.createList();
        //l.addToList("Task 1", "i mean we out here", "1997-07-24");
        //l.addToList("Task 2", "yarg", "1997-07-24");

    }

    // should this be private (also look at other functions)
    private static void mainMenu() {
        System.out.printf("Main Menu%n---------%n%n" +
                "1) create a new list%n" +
                "2) load an existing list%n" +
                "3) quit%n%n");
    }

    private static void opMenu() {
        System.out.printf("1) view the list%n" +
                "2) add an item%n" +
                "3) edit an item%n" +
                "4) remove an item%n" +
                "5) mark an item as completed%n" +
                "6) unmark an item as completed%n" +
                "7) save the current list%n" +
                "8) quit to the main menu%n");
    }
}
