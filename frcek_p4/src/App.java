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
        //l.createList();
        l.addToList("Task 1", "i mean we out here", "1997-07-24");
        l.addToList("Task 2", "yarg", "1997-07-24");

    }
}
