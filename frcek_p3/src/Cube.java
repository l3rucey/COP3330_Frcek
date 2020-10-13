public class Cube extends Shape3D{
    String name = "cube";
    double length;

    public Cube(double length) {
        this.length = length;
    }

    public String getName() {
        return this.name;
    }

    public double getArea() {
        return (Math.pow(this.length, 2)) * 6;
    }

    public double getVolume() {
        return (Math.pow(this.length, 3));
    }
}