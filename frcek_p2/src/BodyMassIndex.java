import java.lang.Math;

public class BodyMassIndex {
    private double h, w;

    public BodyMassIndex(double h, double w) {
        this.h = h;
        this.w = w;
    }

    public double bmiCalc() {
        return Math.round((703 * this.w / Math.pow(this.h, 2)) * 100.0) / 100.0;
    }

    public String bmiCat(double bmi) {
        //double bmi = bmiCalc();

        if (bmi >= 30) {
            return "Obese";
            //System.out.printf("Your BMI is %f\nThis puts you in the Obesity Category.\n", bmi);
        } else if (bmi >= 25) {
            return "Overweight";
            //System.out.printf("Your BMI is %f\nThis puts you in the Overweight Category.\n", bmi);
        } else if (bmi >= 18.5) {
            return "Normal";
            //System.out.printf("Your BMI is %f\nThis puts you in the Normal Weight Category.\n", bmi);
        } else {
            return "Underweight";
            //System.out.printf("Your BMI is %f\nThis puts you in the Underweight Category.\n", bmi);
        }

    }
}