import java.util.Scanner;

abstract class Rectangle {
    private int a;
    private int b;

    public Rectangle(int a, int b) { // constructor with parameter
        this.a = a;
        this.b = b;
    }

    public Rectangle() {

    }

    public void set_a(int a) { // setter method for int a
        this.a = a;
    }

    public int get_a() { // getter method for int a
        return this.a;
    }

    public void set_b(int b) { // setter method for int b
        this.b = b;
    }

    public int get_b() { // getter method for int b
        return this.b;
    }

    abstract public int square_counter();

    abstract public int perimeter_counter();

    abstract public String show();
}

class PRectangle extends Rectangle {

    public PRectangle() { // constructor
        super();
    }

    public PRectangle(int a, int b) { // constructor with parameter
        super(a, b);
    }

    @Override
    public int square_counter() {
        return super.get_a() * super.get_b();
    }

    @Override
    public int perimeter_counter() {
        return (super.get_a() * 2) + (super.get_b() * 2);
    }

    @Override
    public String show() {
        return "A = " + super.get_a() + "\tB = " + super.get_b();
    }

    public boolean is_a_rectangle() {
        if (((super.get_a() * 2) + super.get_b()) > super.get_b()) {
            return true;
        } else {
            return false;
        }

    }

}

public class Rectangle_task1 {
    public static void show_test(PRectangle tr) {
        System.out.println("Rectangle: " + tr.show());
        System.out.println("Is a rectangle(true&false)? " + tr.is_a_rectangle());
        System.out.println("Perimeter:" + tr.perimeter_counter());
        System.out.println("Area:" + tr.square_counter());
        System.out.println();
    }

    public static void main(String[] args) {
        PRectangle tr_1 = new PRectangle(1, 5);
        PRectangle tr_2 = new PRectangle(5, 6);
        show_test(tr_1);
        show_test(tr_2);
    }
}
