public class Square extends Shape2D {
    // does this need to be private or final or anything??
    String name = "square";
    double length;
    //double height; dont need...

    public Square(double length) {
        this.length = length;
    }

    public String getName() {
        return this.name;
    }

    public double getArea() {
        return (this.length * this.length);
    }
}