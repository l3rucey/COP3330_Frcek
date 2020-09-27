import java.lang.Math;

import static java.lang.Math.pow;

public class BodyMassIndex {
    private double bmi;

    public BodyMassIndex(double h, double w) {
        this.bmi = 703 * w / pow(h, 2);
    }

    // Check these conditions later
    public void printTat() {
        if (this.bmi >= 30) {
            System.out.printf("Your BMI is %f\nThis puts you in the Obesity Category.\n", this.bmi);
        } else if (this.bmi >= 25) {
            System.out.printf("Your BMI is %f\nThis puts you in the Overweight Category.\n", this.bmi);
        } else if (this.bmi >= 18.5) {
            System.out.printf("Your BMI is %f\nThis puts you in the Normal Weight Category.\n", this.bmi);
        } else {
            System.out.printf("Your BMI is %f\nThis puts you in the Underweight Category.\n", this.bmi);
        }
    }

}
