import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        appManager();
    }

    private static void appManager() {
        TaskApp taskApp = new TaskApp();
        ContactApp contactApp = new ContactApp();

        while(true) {
            appSelectMenu();
            int menuAnswer = getUserInput();
            if(menuAnswer == 1) {
                taskApp.menuStart();
            } else if (menuAnswer == 2) {
                contactApp.menuStart();
            } else {
                break;
            }
        }
    }

    private static void appSelectMenu() {
        System.out.printf("Select Your Application%n---------%n%n" +
                "1) task list%n" +
                "2) contact list%n" +
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

}
