import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Contains 0 or more "TaskItems"
// Encapsulate list data
public class TaskList {
    // composition? is this composition and do I want this?
    //private TaskItem list;
    private ArrayList<TaskItem> list;

//    // constructor?
//    public TaskList() {
//        // somethin
//    }

    // Pseudocode
    // create a function that makes a list of TaskItems
    // create a function that can load and existing list
    // create a function that can view the list
    // create a function that can save the list
    // create a function that can add to the list
    // etc.

    public void createList() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        try(Formatter output = new Formatter("Todo.txt")) {
            // Do we want this.. will it create a null char we don't want?
            output.format("");
        } catch(FileNotFoundException ex) {
            System.out.println("dat file don't exist doe");
        }
        this.list = list;
    }

    public void addToList(String title, String description, String date) {
        // WHY DID I NEED THE FILE WRITER IN THE TRY PARAM IN ORDER FOR IT TO WORK?
        try(FileWriter f = new FileWriter("Todo.txt", true)) {
            Formatter output = new Formatter(f);
            output.format("%s %s %s%n", title, description, date);
            //f.close();
        } catch (IOException ex) {
            System.out.println("wat u doin son");
        }
    }

    public void closeFile() {

    }

}
