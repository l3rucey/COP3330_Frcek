import java.util.ArrayList;
import java.util.Scanner;

// COPY PASTE THE MAIN CLASS SO ITS THE SAME AS ASSIGNMENT
public class App {
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want your BMI calculated and displayed?\nEnter Y or N: ");
        String check = input.nextLine();
        if (check.equals("Y") || check.equals("y")) {
            return true;
        }
        return false;
    }
    public static double getUserHeight() {
        Scanner input = new Scanner(System.in);
        double height = 0;
        int check = 0;

        while (check <= 0) {
            System.out.print("Whats your height?\nEnter here: ");
            height = input.nextDouble(); // cant use next double?
            if (height <=0) {
                System.out.println("thats not possible. try again.");
            } else {
                check = 1;
            }
        }

        System.out.println("Your height is " + height);

        return height;
    }

    public static double getUserWeight() {
        Scanner input = new Scanner(System.in);
        double weight = 0;
        int check = 0;

        while (check <= 0) {
            System.out.print("Whats your weight?\nEnter here: ");
            weight = input.nextDouble();
            if (weight <=0) {
                System.out.println("thats not possible. try again.");
            } else {
                check = 1;
            }
        }
        System.out.println("Your weight is " + weight);

        return weight;
    }

    public static void displayBmiInfo(BodyMassIndex data) {
        System.out.println("The categories for weight go as follows:\n");
        System.out.printf("Underweight < 18.5\nNormal weight = 18.5–24.9\nOverweight = 25–29.9\nObesity >= 30\n\n");
        data.printTat();
    }

    // PRINTS OUT AVERAGE OF DATA
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> data) {
        int i, size = data.size();
        double avg = 0;
        /*
        for (i = 0; i < size; i++) {
            System.out.println(data);
        }

         */
        /*
        for (i = 0; i < size; i++) {
            //System.out.println(data.getBmi);
            System.out.println(data.get(i));
        }
        */
        for (BodyMassIndex ob : data) {
            System.out.println(ob.getBmi());
            avg += ob.getBmi();
        }

        avg = avg/size;
        System.out.println("About to see avg");
        System.out.println(avg);


        //System.out.println(data.bmi);

        /*
        //look at later
        for (BodyMassIndex i : data) {
            System.out.println(data.get(0));
            System.out.println(this.data(i));
        }
        */
    }


}