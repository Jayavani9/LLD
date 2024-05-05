
class Rectangle implements Shape {
    private final int length;
    private final int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int calcArea() {
        return length * width;
    }

    public int calcPerimeter() {
        return 2 * (length + width);
    }
}

class Square implements Shape {
    private final int length;

    public Square(int length) {
        this.length = length;
    }

    public int calcArea() {
        return length * length;
    }

    public int calcPerimeter() {
        return 4 * length;
    }

}

public class RectSq {
    public static void main(String[] args) {
        Shape rect = new Rectangle(2, 3);
        Shape sq = new Square(3);

        System.out.println(rect.calcArea());
        System.out.println(rect.calcPerimeter());
        System.out.println(sq.calcArea());
        System.out.println(sq.calcPerimeter());
    }

}
