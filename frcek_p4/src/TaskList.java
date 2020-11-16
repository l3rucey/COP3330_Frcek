import java.io.File;
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
    //private TaskItem item;
    private ArrayList<TaskItem> itemList;

//    // constructor?
//    public TaskList() {
//        // somethin
//    }

    // Creates a list.. sets address of list to public list
    // Apparently you cant do a formatter by w/o a tryblock.. cant help but feel that
    // im doing this wrong...
    public void createList() {
        // do we create the itemList here or globally??
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        // should we throw exceptions or use a try?
        try {
            File file = new File("Todo.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.itemList = list;
    }

    public void viewList() {
        try {
            File temp = new File("Todo.txt");
            Scanner scan = new Scanner(temp);
            System.out.printf("Current Tasks%n---------%n%n");
            int i = 0;
            while(scan.hasNext()) {
                System.out.printf("%d) %s%n", i, scan.nextLine());
                i++;
            }
        } catch (IllegalArgumentException | FileNotFoundException ex) {
            System.out.println("WATER U DOIN");
        }
    }

    // do i want this for the addToList prompt??
    public void promptUser() {

    }

    public void addToList() {
        try(FileWriter f = new FileWriter("Todo.txt", true)) {
            TaskItem newTask = new TaskItem();
            Formatter output = new Formatter(f);
            Scanner scan = new Scanner(System.in);

            System.out.printf("Task title: ");
            newTask.setTitle(scan.nextLine());
            System.out.printf("Task description: ");
            newTask.setDescription(scan.nextLine());
            System.out.printf("Task due date (YYYY-MM-DD): ");
            newTask.setDate(scan.nextLine());

            itemList.add(newTask);

            output.format("[%s] %s: %s%n", newTask.getDate(), newTask.getTitle(), newTask.getDescription());

        } catch (IOException ex) {
            System.out.println("u fd up");
        }
    }

//    public void editList() {
//        itemList
//    }



    public void closeFile() {

    }

}

//    private Formatter x;
//
//    public void openFile() {
//        try {
//            x= new Formatter("japanese.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void addRec() {
//        x.format("%s%s%s", "8 ", "Bruce", "Frcek");
//    }
//
//    public void closeFile() {
//        x.close();
//    }