public class Square extends Shape2D {
    String name = "square";
    double length;

    public Square(double length) {
        this.length = length;
    }

    public String getName() {
        return this.name;
    }

    public double getArea() {
        return (Math.pow(this.length, 2));
    }
}