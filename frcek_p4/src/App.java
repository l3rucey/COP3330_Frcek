import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

// Handles interaction with user (simplify main later)
public class App {
    public static void main(String[] args) {
        menuStart();
    }

    private static void menuStart() {
        TaskList list = new TaskList();
        Scanner input = new Scanner(System.in);
        while(true) {
            mainMenu();
            int mainMenuAnswer = getUserInput();
            if (mainMenuAnswer == 1) {
                list.createList();
                while (true) {
                    opMenu();
                    int opMenuAnswer = getUserInput();
                    //int opMenuAnswer = input.nextInt();
                    if (opMenuAnswer == 1) {
                        list.viewList();
                        //input.nextLine();
                    } else if (opMenuAnswer == 2) {
                        list.addToList();
                    } else if (opMenuAnswer == 3) {
                        list.viewList();
                        list.editList();
                    } else if (opMenuAnswer == 4) {
                        list.viewList();
                        list.removeItem();
                    } else if (opMenuAnswer == 5) {
                        list.markItem();
                    } else if (opMenuAnswer == 6) {
                        list.unMarkItem();
                    } else if (opMenuAnswer == 7){
                        list.saveFile();
                    } else if (opMenuAnswer == 8){
                        break;
                    } else {
                        System.out.println("ERROR! Enter an integer value between [1-8] inclusive");
                    }
                }
            } else if (mainMenuAnswer == 2) {
                System.out.printf("I haven't added that functionality yet :D%n");
            } else {
                System.exit(0);
            }
        }
    }

    // should this be private (also look at other functions)
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

        while(repeat) {
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
                "5) mark an item as completed%n" +
                "6) unmark an item as completed%n" +
                "7) save the current list%n" +
                "8) quit to the main menu%n%n");
    }
}