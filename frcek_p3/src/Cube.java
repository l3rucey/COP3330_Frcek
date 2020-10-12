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
        return (this.length * this.length) * 6;
    }

    public double getVolume() {
        return (this.length * this.length * this.length);
    }
}