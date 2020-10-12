public class Sphere extends Shape3D{
    String name = "sphere";
    double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public String getName() {
        return this.name;
    }

    public double getArea() {
        return 4*Math.PI*Math.pow(radius, 2);
    }

    // Why does changing the (4.0/3.0) to (4/3) give wrong answer?
    public double getVolume() {
        return (4.0/3.0)*Math.PI*Math.pow(radius, 3);
    }
}
