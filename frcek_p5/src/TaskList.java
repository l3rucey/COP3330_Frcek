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

public class TaskList {
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

    public void addToList(String title, String description, String date) {
        try {
            if(title.length() < 1) {
                throw new IllegalArgumentException("ERROR: A title needs to be 1 or more characters in length");
            }
            // didn't have time to do full validation
            if(date.length() != 10) {
                throw new IllegalArgumentException("ERROR: A due date needs to be in the format of YYYY-MM-DD");
            }
//            newTask.setTitle(title);
//            newTask.setDescription(description);
//            newTask.setDate(date);
            TaskItem newTask = new TaskItem(title, description, date);
            itemList.add(newTask);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void editList(int index, int size, String title, String description, String date) {
        try {
            if (size == 0) {
                throw new IllegalArgumentException("ERROR: No existing tasks");
            }
            if(index > size || index < 0) {
                throw new IllegalArgumentException("ERROR: Choose an available index");
            }
            // comeback to this if things break...
            if(date.length() != 10) {
                throw new IllegalArgumentException("ERROR: A due date needs to be in the format of YYYY-MM-DD");
            }
//            temp.setTitle(title);
//            temp.setDescription(description);
//            temp.setDate(date);
            TaskItem temp = new TaskItem(title, description, date);
            itemList.set(index, temp);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void removeItem(int index, int size) {
        try {
            if (size == 0) {
                throw new IllegalArgumentException("ERROR: No existing tasks");
            }
            if(index > size || index < 0) {
                throw new IllegalArgumentException("ERROR: Choose an available index");
            }
            itemList.remove(index);
        } catch (Exception ex) {
            System.out.println("Enter proper index or no tasks available to remove");
        }
    }

    public void markItem(int userInput, int uncompletedListSize) {
        try {
            if(uncompletedListSize == 0) {
                throw new IllegalArgumentException("ERROR: There are no uncompleted tasks");
            }
            if(userInput > uncompletedListSize || userInput < 0) {
                throw new IllegalArgumentException("ERROR: Choose an existing task");
            }
            itemList.get(userInput).setMark(true);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void unMarkItem(int userInput, int completedListSize) {
        try {
            if(completedListSize == 0) {
                throw new IllegalArgumentException("ERROR: There are no Completed tasks");
            }
            if(userInput > completedListSize || userInput < 0) {
                throw new IllegalArgumentException("ERROR: Choose an existing task");
            }
            itemList.get(userInput).setMark(false);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveFile(String fileName) {
        try {
            Formatter file = new Formatter(fileName);
            for (TaskItem item: itemList) {
                file.format("%s %s %s%n",
                        item.getDate(),
                        item.getTitle(),
                        item.getDescription());
            }
            file.close();
            System.out.println("task list has been saved");
        } catch (Exception ex) {
            System.out.println("u meeesxdfsdf upsadfasfd");
        }
        System.out.println("");
    }

    public void loadList(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            ArrayList<TaskItem> list = new ArrayList<TaskItem>();
            while(scan.hasNext()) {
                String title;
                String description;
                String date;
                date = scan.next();
                title = scan.next();
                description = scan.next();
                TaskItem temp = new TaskItem(title, description, date);
                list.add(temp);
            }
            this.itemList = list;
            System.out.printf("task list has been loaded%n%n");
        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist!");
        } catch (Exception ex) {
            System.out.println("what just happened!??");
        }
    }

    public ArrayList<TaskItem> getItemList() {
        return this.itemList;
    }

}