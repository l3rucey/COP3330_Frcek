import java.util.ArrayList;
import java.util.Scanner;

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
        return false; //should i change this
    }

    public static double getUserHeight() {
        Scanner input = new Scanner(System.in);
        double height = 0;
        int check = 0;

        while (check <= 0) {
            System.out.print("What is your height in inches?\nEnter here: ");
            height = input.nextDouble();
            if (height <=0) {
                System.out.println("That is not possible. Please try again.");
            } else {
                check = 1;
            }
        }

        return height;
    }

    public static double getUserWeight() {
        Scanner input = new Scanner(System.in);
        double weight = 0;
        int check = 0;

        while (check <= 0) {
            System.out.print("Whats your weight in pounds?\nEnter here: ");
            weight = input.nextDouble();
            if (weight <=0) {
                System.out.println("That is not possible. Please try again.");
            } else {
                check = 1;
            }
        }

        return weight;
    }

    public static void displayBmiInfo(BodyMassIndex data) {
        double bmi = data.bmiCalc();
        String category = data.bmiCat(bmi);

        System.out.println("\nThe categories for weight go as follows:\n");
        System.out.print("Underweight < 18.5\nNormal weight = 18.5–24.9\nOverweight = 25–29.9\nObesity >= 30\n\n");
        System.out.printf("\nYour bmi %f this places you in the %s category.\n", bmi, category);
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> data) {
        int i, size = data.size();
        double avg = 0;

        for (BodyMassIndex ob : data) {
            avg += ob.bmiCalc();
        }
        avg = avg/size;

        System.out.println("\nThe average BMI of all users is: " + avg);

    }

}