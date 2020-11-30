import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Handles interaction with user (simplify main later)
public class TaskApp {

    public void menuStart() {
        TaskList taskList = new TaskList(); // instantiation of a TaskList
        //ContactList contactList = new ContactList(); // instantiation of a ContactList
        Scanner input = new Scanner(System.in);
        while (true) {
            mainMenu();
            int mainMenuAnswer = getUserInput();
            if (mainMenuAnswer == 1) {
                taskList.createList();
                while (true) {
                    opMenu();
                    int opMenuAnswer = getUserInput();
                    //int opMenuAnswer = input.nextInt();
                    if (opMenuAnswer == 1) {
                        taskList.viewList();
                    } else if (opMenuAnswer == 2) {
                        _addToList(taskList);
                    } else if (opMenuAnswer == 3) {
                        taskList.viewList();
                        _editList(taskList);
                    } else if (opMenuAnswer == 4) {
                        taskList.viewList();
                        _removeItem(taskList);
                    } else if (opMenuAnswer == 5) {
                        _markItem(taskList);
                    } else if (opMenuAnswer == 6) {
                        _unMarkItem(taskList);
                    } else if (opMenuAnswer == 7) {
                        _saveFile(taskList);
                    } else if (opMenuAnswer == 8) {
                        break;
                    } else {
                        System.out.println("ERROR! Enter an integer value between [1-8] inclusive");
                    }
                }
            } else if (mainMenuAnswer == 2) {
                _loadList(taskList);
                while (true) {
                    opMenu();
                    int opMenuAnswer = getUserInput();
                    //int opMenuAnswer = input.nextInt();
                    if (opMenuAnswer == 1) {
                        taskList.viewList();
                    } else if (opMenuAnswer == 2) {
                        _addToList(taskList);
                    } else if (opMenuAnswer == 3) {
                        taskList.viewList();
                        _editList(taskList);
                    } else if (opMenuAnswer == 4) {
                        taskList.viewList();
                        _removeItem(taskList);
                    } else if (opMenuAnswer == 5) {
                        _markItem(taskList);
                    } else if (opMenuAnswer == 6) {
                        _unMarkItem(taskList);
                    } else if (opMenuAnswer == 7) {
                        _saveFile(taskList);
                    } else if (opMenuAnswer == 8) {
                        break;
                    } else {
                        System.out.println("ERROR! Enter an integer value between [1-8] inclusive");
                    }
                }
            } else {
                System.exit(0);
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

    private static void _addToList(TaskList list) {
        //TaskItem newTask = new TaskItem(); I dont need this right??
        Scanner input = new Scanner(System.in);

        String title;
        String description;
        String date;

        System.out.print("Task title: ");
        title = input.nextLine();
        System.out.print("Task description: ");
        description = input.nextLine();
        System.out.print("Task due date (YYYY-MM-DD): ");
        date = input.nextLine();

        list.addToList(title, description, date);
    }

    private static void _editList(TaskList list) {
        try {
            Scanner scan = new Scanner(System.in);
            int index;
            String title;
            String description;
            String date;
            System.out.print("Which task will you edit? ");
            index = scan.nextInt();
            scan.nextLine(); // for buffer i think.
            System.out.printf("Enter a new title for task %d: ", index);
            title = scan.nextLine();
            System.out.printf("Enter a new description for task %d: ", index);
            description = scan.nextLine();
            System.out.printf("Enter a new task due date (YYYY-MM-DD) for task %d: ", index);
            date = scan.nextLine();

            list.editList(index, list.getItemList().size(), title, description, date);

        } catch (Exception ex) {
            System.out.println("ERROR: Ill add an actual msg here soon");
        }
    }

    private static void _removeItem(TaskList list) {
        int index;
        int size = list.getItemList().size();
        Scanner input = new Scanner(System.in);
        System.out.print("Which task will you remove? ");
        index = input.nextInt();
        input.nextLine();

        list.removeItem(index, size);
    }

    private static void _markItem(TaskList list) {
        int size = list.getItemList().size();
        int userInput;
        int uncompletedListSize = 0;
        Scanner input = new Scanner(System.in);
        System.out.printf("Uncompleted Tasks%n----------------%n%n");
        for (int i = 0; i < size; i++) {
            if (!list.getItemList().get(i).getMark()) {
                System.out.printf("%d) [%s] %s: %s%n", i,
                        list.getItemList().get(i).getDate(),
                        list.getItemList().get(i).getTitle(),
                        list.getItemList().get(i).getDescription());
                uncompletedListSize++;
            }
        }
        userInput = input.nextInt();
        list.markItem(userInput, uncompletedListSize);
    }

    private static void _unMarkItem(TaskList list) {
        int size = list.getItemList().size();
        int userInput;
        int completedListSize = 0;
        Scanner input = new Scanner(System.in);
        System.out.printf("Completed Tasks%n----------------%n%n");
        for (int i = 0; i < size; i++) {
            if (list.getItemList().get(i).getMark()) {
                System.out.printf("%d) [%s] %s: %s%n", i,
                        list.getItemList().get(i).getDate(),
                        list.getItemList().get(i).getTitle(),
                        list.getItemList().get(i).getDescription());
                completedListSize++;
            }
        }
        userInput = input.nextInt();
        list.unMarkItem(userInput, completedListSize);
    }

    private static void _saveFile(TaskList list) {
        String fileName;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename to save as: ");
        fileName = input.nextLine();
        list.saveFile(fileName);
    }

    private static void _loadList(TaskList list) {
        Scanner input = new Scanner(System.in);
        String fileName;
        System.out.print("Enter the filename to load: ");
        fileName = input.nextLine();
        list.loadList(fileName);
    }

    private static void opMenu() {
        System.out.printf("%nList Operation Menu%n-------------------%n%n" +
                "1) view the list%n" +
                "2) add an item%n" +
                "3) edit an item%n" +
                "4) remove an item%n" +
                "5) mark an item as completed%n" +
                "6) unmark an item as completed%n" +
                "7) save the current list%n" +
                "8) quit to the main menu%n%n");
    }
}