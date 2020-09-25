import static java.lang.StrictMath.pow;

public class BodyMassIndex {
    private double bmi;

    public BodyMassIndex(double pounds, double height) {
        this.bmi = pow(height, 2);
        System.out.println(bmi);
        this.bmi = 703 * pounds / pow(height, 2);
        System.out.println(bmi);
    }
    /*
    public static void printDat() {
        System.out.println(bmi);
    }
     */
}
