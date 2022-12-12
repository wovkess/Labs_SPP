public class task1 {

    public static void main(String[] args) {
        LaserPrinter laserPrinter = new LaserPrinter(300, true, 7);
        laserPrinter.print();
    }

}

interface PrintingDevice {
    void print();

    int textLength();
}

class Printer implements PrintingDevice {
    int maxTextLength;
    boolean wifi;

    Printer(int maxTextLength, boolean wifi) {
        this.wifi = wifi;
        this.maxTextLength = maxTextLength;
    }

    public void print() {
        System.out.println("Maximum string length: " + maxTextLength + " \n" + "Havin'g wi-fi: " + wifi
                + "\nString length now: " + textLength());
    }

    public int textLength() {
        return 1;
    }
}

class LaserPrinter extends Printer {
    private int maxTextLength;

    LaserPrinter(int maxTextLength, boolean wifi, int recordWeight) {
        super(maxTextLength, wifi);
        this.maxTextLength = maxTextLength;
    }

    public int textLength() {
        return 10;
    }

}