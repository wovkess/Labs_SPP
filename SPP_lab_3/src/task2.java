class Library {
    int number;
    String author;
    String name;
    int year;
    int count;
    int sheet_count;
    int tom_count;
    String name_get;
    int deadline;

    public Library(int number, String author, String name, int year, int count, String name_get, int deadline) {
        this.number = number;
        this.author = author;
        this.name = name;
        this.year = year;
        this.count = count;
        this.name_get = name_get;
        this.deadline = deadline;
    }

    public Library() {

    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public void setName_get(String name_get) {
        this.name_get = name_get;
    }

    public String getName_get() {
        return this.name_get;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getDeadline() {
        return this.deadline;
    }

    void displayInfo() {
        System.out.println("UDK: " + number);
        System.out.println("Author: " + author);
        System.out.println("Name of the book: " + name);
        System.out.println("The year of publishing: " + year);
        System.out.println("The number of copies in the library: " + count);
        System.out.println("The number of sheets in the book: " + sheet_count);
        System.out.println("The number of toms in the book: " + tom_count);
        System.out.println("The name of person, who took the book: " + name_get);
        System.out.println("Timeout of using book: " + deadline);
    }

    public String bookList() {
        return getName();
    }

}

public class task2 {

    public static void showInf(Library tr) {
        System.out.print(tr.bookList());
    }

    public static void main(String[] args) {
        Library[] book1 = new Library[9];
        Library[] book2 = new Library[9];
        Library[] book3 = new Library[9];

        book1[0].number = 4132;
        book1[1].author = "Dostoevski F.M.";
        book1[2].name = "Prestuplenie i nakazanie";
        book1[3].year = 1866;
        book1[4].count = 41;
        book1[5].sheet_count = 608;
        book1[6].tom_count = 15;
        book1[7].name_get = "Petrov P.P.";
        book1[8].deadline = 17;
        // -----------------------------
        book2.number = 5142;
        book2.author = "Pushkin A.S.";
        book2.name = "Kapitanskaya Dochka";
        book2.year = 1836;
        book2.count = 28;
        book2.sheet_count = 320;
        book2.tom_count = 1;
        book2.name_get = "Ivanov I.I.";
        book2.deadline = 14;
        // -----------------------------
        book3.number = 9402;
        book3.author = "Gogol N.V.";
        book3.name = "Revizor";
        book3.year = 1809;
        book3.count = 9;
        book3.sheet_count = 125;
        book3.tom_count = 2;
        book3.name_get = "Sidorov A.P.";
        book3.deadline = 7;
    }
}
