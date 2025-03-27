package Shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle( Double radius) {
        this.radius = radius;
    }


    @Override
    public Double calculatePerimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public Double calculateArea() {
        return 3.14 * Math.pow(radius, 2);
    }
}
