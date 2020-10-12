public class Circle extends Shape2D{
    String name = "circle";
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getName() {
        return this.name;
    }

    // should I use actual pi?
    public double getArea() {
        return (radius * radius) * Math.PI;
    }
}