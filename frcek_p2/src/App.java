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

        //displayBmiStatistics(bmiData);

        //moreInput();
        //getUserHeight();
        //getUserWeight();
    }

    public static boolean moreInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want your BMI calculated and displayed?\nEnter 1 or 0: ");
        int check = input.nextInt();
        return check == 1;
    }

    public static double getUserHeight() {
        Scanner input = new Scanner(System.in);
        double height = 0;
        int check = 0;

        while (check <= 0) {
            System.out.print("Whats your height bub?\nEnter here: ");
            height = input.nextDouble();
            if (height <=0) {
                System.out.println("bro thats not possible. try again.");
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
            System.out.print("Whats your weight bub?\nEnter here: ");
            weight = input.nextDouble();
            if (weight <=0) {
                System.out.println("bro thats not possible. try again.");
            } else {
                check = 1;
            }
        }

        System.out.println("Your weight is " + weight);

        return weight;
    }

    public static void displayBmiInfo(BodyMassIndex data) {

        //System.out.println("Yo DAWG. your B M I... its ");
        data.printTat();

        /*
        Underweight < 18.5
        Normal weight = 18.5–24.9
        Overweight = 25–29.9
        Obesity >= 30

         */
    }
/*
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> data) {

    }
*/

}
