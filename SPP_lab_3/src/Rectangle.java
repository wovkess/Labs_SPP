import java.util.Scanner;

public class Rectangle {
    private int square_counter;
    private int perimeter_counter;
    private int a, b;
    private int checked;

    public Rectangle() { // constructor

    }

    public Rectangle(int square_counter, int perimeter_counter, int a, int b, int checked) {
        this.square_counter = square_counter;
        this.perimeter_counter = perimeter_counter;
        this.a = a;
        this.b = b;
        this.checked = checked;
    }

    public void setSquare_counter(int a, int b) {
        this.square_counter = a * b;
    }

    public int getSquare_counter() {
        return square_counter;
    }

    public void setPerimeter_counter(int a, int b) {
        this.perimeter_counter = (a * 2) + (b * 2);
    }

    public int getPerimeter_counter() {
        return perimeter_counter;
    }

    public int setChecked(int checked) {
        return checked;
    }

    public void getCheck(int a, int b) {
        if (a != b) {
            System.out.println("This is rectangle");
        } else {
            System.out.println("This is square");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        try {
            Rectangle rectangle = new Rectangle(0, 0, 0, 0, 0);
            rectangle.getCheck(3, 4);
            rectangle.setSquare_counter(3, 4);
            System.out.println("The square of the rectangle is: " + rectangle.getSquare_counter());
            rectangle.setPerimeter_counter(3, 4);
            System.out.println("The perimeter of the rectangle is: " + rectangle.getPerimeter_counter());
        } finally {
            sc.close();
        }
    }
}
