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
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        System.out.printf("new task list has been created%n%n");
        this.itemList = list;
    }

    public void viewList() {
        int size = itemList.size();
        System.out.printf("Current Tasks%n-------------%n%n");
        for (int i = 0; i < size; i++) {
            if(itemList.get(i).getMark()) {
                System.out.printf("*** %d) [%s] %s: %s%n", i,
                        itemList.get(i).getDate(),
                        itemList.get(i).getTitle(),
                        itemList.get(i).getDescription());
            } else {
                System.out.printf("%d) [%s] %s: %s%n", i,
                        itemList.get(i).getDate(),
                        itemList.get(i).getTitle(),
                        itemList.get(i).getDescription());
            }
        }
        System.out.printf("%n");
    }

    public void addToList() {
        TaskItem newTask = new TaskItem();
        Scanner scan = new Scanner(System.in);
        System.out.printf("Task title: ");
        newTask.setTitle(scan.nextLine());
        System.out.printf("Task description: ");
        newTask.setDescription(scan.nextLine());
        System.out.printf("Task due date (YYYY-MM-DD): ");
        newTask.setDate(scan.nextLine());

        itemList.add(newTask);
    }

//    public void printArray() {
//        int i, size = itemList.size();
//        for (i = 0; i < size; i++) {
//            System.out.printf("listItem[%d] = %s%n",i, itemList.get(i).getTitle());
//        }
//    }

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
    }

    public void removeItem() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Which task will you remove? ");
            int index = scan.nextInt();
            scan.nextLine(); // for buffer i think.
            itemList.remove(index);
        } catch (Exception ex) {
            System.out.println("u meeesssed up");
        }
    }

    public void markItem() {
        int size = itemList.size();
        int userInput = 0;
        Scanner input = new Scanner(System.in);
        System.out.printf("Uncompleted Tasks%n----------------%n%n");
        for (int i = 0; i < size; i++) {
            if(!itemList.get(i).getMark()) {
                System.out.printf("%d) [%s] %s: %s%n", i,
                        itemList.get(i).getDate(),
                        itemList.get(i).getTitle(),
                        itemList.get(i).getDescription());
            }
        }
        userInput = input.nextInt();
        itemList.get(userInput).setMark(true);
    }

    public void unMarkItem() {
        int size = itemList.size();
        int userInput = 0;
        Scanner input = new Scanner(System.in);
        System.out.printf("Completed Tasks%n----------------%n%n");
        for (int i = 0; i < size; i++) {
            if(itemList.get(i).getMark()) {
                System.out.printf("%d) [%s] %s: %s%n", i,
                        itemList.get(i).getDate(),
                        itemList.get(i).getTitle(),
                        itemList.get(i).getDescription());
            }
        }
        userInput = input.nextInt();
        itemList.get(userInput).setMark(false);
    }

    public void saveFile() {
        String fileName;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename to save as: ");
        fileName = input.nextLine();
        try {
            Formatter file = new Formatter(fileName);
            for (TaskItem item: itemList) {
                file.format("[%s] %s: %s%n",
                        item.getDate(),
                        item.getTitle(),
                        item.getDescription());
            }
            file.close();
            System.out.println("task list has been saved");
        } catch (IOException ex) {
            System.out.println("u meeesxdfsdf upsadfasfd");
        }
    }

    public void loadList() {
        Scanner input = new Scanner(System.in);
        String fileName;
        System.out.print("Enter the filename to load: ");
        fileName = input.nextLine();
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            ArrayList<TaskItem> list = new ArrayList<TaskItem>();
            TaskItem temp = new TaskItem();
            while(scan.hasNext()) {
                temp.setDate(scan.next()); // how to index with scan.next()[1- or 1, ]
                temp.setTitle(scan.next());
                temp.setDescription(scan.next());
                list.add(temp);
            }
            this.itemList = list;
        } catch (Exception ex) {
            System.out.println("File does not exist!");
        }

        System.out.printf("task list has been loaded%n%n");
    }

}