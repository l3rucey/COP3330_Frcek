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
        } else if (bmi >= 25) {
            return "Overweight";
        } else if (bmi >= 18.5) {
            return "Normal";
        } else {
            return "Underweight";
        }
    }
}