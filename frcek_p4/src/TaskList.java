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

    public void createList() {
        // do we create the itemList here or globally??
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        // should we throw exceptions or use a try?
        try {
            File file = new File("Todo.txt");
            System.out.printf("new task list has been created%n%n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.itemList = list;
    }

    // i think i need to check if the user decieded to create a new list or load
    // i can make an if conditional for input 1 or 2 and then this view will
    // either read from the file in a load option or read from array in a create option
    // or maybe try and always read from file but if not able then read from array
    public void viewList() {
        try {
            File temp = new File("Todo.txt");
            Scanner scan = new Scanner(temp);
            System.out.printf("Current Tasks%n-------------%n%n");
            int i = 0;
            while(scan.hasNext()) {
                System.out.printf("%d) %s%n", i, scan.nextLine());
                i++;
            }
            System.out.printf("%n");
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
        } catch (NoSuchElementException ex) {
            System.out.println("sheeeesh");
        }
    }

    public void printArray() {
        int i, size = itemList.size();
        for (i = 0; i < size; i++) {
            System.out.printf("listItem[%d] = %s%n",i, itemList.get(i).getTitle());
        }
    }

    // fix issue if there is nothing in list
    // so like "if list == 0 return error and prompt"
    // WHYYY DID I GET A NOSUCHELEMENTEXCEPTION WHEN THE SCANNER WAS IN THE TRY PARAM...
    public void editList() {
        try {
            Scanner scan = new Scanner(System.in);
            TaskItem temp = new TaskItem();
            System.out.print("Which task will you edit? ");
            int index = scan.nextInt();
            scan.nextLine(); // for buffer i think.
            System.out.printf("Enter a new title for task %d: ", index);
            temp.setTitle(scan.nextLine());
            System.out.printf("Enter a new description for task %d: ", index);
            temp.setDescription(scan.nextLine());
            System.out.printf("Enter a new task due date (YYYY-MM-DD) for task %d: ", index);
            temp.setDate(scan.nextLine());

            itemList.set(index, temp);

        } catch (Exception ex) {
            System.out.println("u meeesssed up");
        }

        try(Formatter f = new Formatter("Todo.txt")) {

            int i, size = itemList.size();

            for (i = 0; i < size; i++) {
                f.format("[%s] %s: %s%n",
                        itemList.get(i).getDate(),
                        itemList.get(i).getTitle(),
                        itemList.get(i).getDescription());
            }
        } catch (FileNotFoundException e) {
            System.out.println("y u do dis");
        }
    }

    public void removeItem() {
        viewList();
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Which task will you remove? ");
            int index = scan.nextInt();
            scan.nextLine(); // for buffer i think.
            itemList.remove(index);
        } catch (Exception ex) {
            System.out.println("u meeesssed up");
        }

        try(Formatter f = new Formatter("Todo.txt")) {

            int i, size = itemList.size();

            for (i = 0; i < size; i++) {
                f.format("[%s] %s: %s%n", itemList.get(i).getDate(),
                        itemList.get(i).getTitle(),
                        itemList.get(i).getDescription());
            }
        } catch (FileNotFoundException e) {
            System.out.println("y u do dis");
        }
    }

    public void markItem() {
        // add safty if itemlist = null
        int size = itemList.size();
        int counter = 0;
        int userInput = 0;
        Scanner input = new Scanner(System.in);
        System.out.printf("Uncompleted Tasks%n----------------%n%n");
        for (int i = 0; i < size; i++) {
            if(itemList.get(i).getMark() == false) {
                System.out.printf("%d) [%s] %s: %s%n", i,
                        itemList.get(i).getDate(),
                        itemList.get(i).getTitle(),
                        itemList.get(i).getDescription());
            }
        }
        userInput = (input.nextInt() + 1); // make sure this is adding int 1 and not moving next
        for (int j = 0; j < size; j++) {
            if(itemList.get(j).getMark() == false) {
                counter++;
                if(userInput == counter) {
                    itemList.get(j).setMark(true);
                }
            }
        }

        try(Formatter f = new Formatter("Todo.txt")) {
            int k;
            for (k = 0; k < size; k++) {
                if (itemList.get(k).getMark() == true) {
                    f.format("*** [%s] %s: %s%n", itemList.get(k).getDate(),
                            itemList.get(k).getTitle(),
                            itemList.get(k).getDescription());
                } else {
                    f.format("[%s] %s: %s%n", itemList.get(k).getDate(),
                            itemList.get(k).getTitle(),
                            itemList.get(k).getDescription());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("y u do dis");
        }
    }

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