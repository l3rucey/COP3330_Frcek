public class Triangle extends Shape2D{
    String name = "triangle";
    double length;
    double height;

    public Triangle(double length, double height) {
        this.length = length;
        this.height = height;
    }

    public String getName() {
        return this.name;
    }

    public double getArea() {
        return ((this.length * this.height) / 2);
    }
}