public class Circle extends Shape2D{
    String name = "circle";
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getName() {
        return this.name;
    }

    public double getArea() {
        return (Math.pow(radius, 2)) * Math.PI;
    }
}