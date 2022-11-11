import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Library {
    private Book[] books;

    Map<String, Integer> buf = Map.of(
            "author", 0,
            "title", 1,
            "publishYear", 2,
            "copies", 3,
            "pages", 4,
            "volumes", 5,
            "number", 6,
            "fio", 7,
            "period", 8);

    public Library(int size) {
        books = new Book[size];
    }

    public static void main(String[] args) {
        List<String> strings = Input_File("D:/Study/Java/Labs_SPP/SPP_lab_3/txt_files/books_list.txt");
        int numberOfBooks = strings.size();
        String[][] arr = new String[numberOfBooks][];

        int i = 0;
        for (String str : strings) {
            arr[i++] = str.split("\\s");
        }

        Library lb = new Library(numberOfBooks);
        lb.testLibrary(arr);
    }

    void ListOfBooks(Book[] Books) {
        for (Book book : Books) {
            System.out.print(book.getTitle() + "|___|");
        }
    }

    Calendar calendar = Calendar.getInstance();
    int week_year = calendar.getWeekYear();

    void OlderBooks(Book[] Books, int year) {
        for (Book book : Books) {
            int pubYear = book.getYear();
            if (pubYear < (week_year - year)) {
                System.out.print(book.getTitle() + "|___|");
            }
        }
    }

    void TakeBooks(Book[] Books) {
        for (Book book : Books) {
            String Read = book.getRead();
            if (!Read.equals("passed")) {
                System.out.print(book.getTitle() + "|___|");
            }
        }
    }

    void TakeBooks_WithFIO(Book[] Books) {
        for (Book book : Books) {
            String Read = book.getRead();
            String FIO = book.getFIO();
            if (!Read.equals("null")) {
                System.out.print(book.getTitle() + ": " + FIO + "|___|");
            }
        }
    }

    void Delay(Book[] Books, int BookWithReader) {
        for (Book book : Books) {
            String Read = book.getRead();
            if (!Read.equals("passed") && Integer.parseInt(Read) > BookWithReader) {
                System.out.print(book.getTitle() + "|___|");
            }
        }
    }

    void testLibrary(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            books[i] = new Book(arr[i][buf.get("author")], arr[i][buf.get("title")],
                    arr[i][buf.get("publishYear")], arr[i][buf.get("copies")], arr[i][buf.get("pages")],
                    arr[i][buf.get("volumes")], arr[i][buf.get("number")], arr[i][buf.get("fio")],
                    arr[i][buf.get("period")]);
            System.out.println(books[i].toString());
        }

        System.out.println("\nBOOKS");
        ListOfBooks(books);

        System.out.println("\nBooks older than 100 years");
        OlderBooks(books, 100); // выбор возраста книги

        System.out.println("\nTAKEN BOOKS");
        TakeBooks(books);

        System.out.println("\nFIO OF TAKEN BOOKS");
        TakeBooks_WithFIO(books);

        System.out.println("\nOverdue books");
        Delay(books, 14); // задача срока сдачи книги
    }

    @Override
    public String toString() {
        return "LibraryManager [books=" + Arrays.toString(books) + "]";
    }

    public static List<String> Input_File(String fileName) {
        List<String> strings = new ArrayList<>();

        try (Scanner file = new Scanner(new File(fileName))) {
            while (file.hasNextLine()) {
                strings.add(file.nextLine());
            }
            file.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return strings.stream().map(String::trim).collect(Collectors.toList());
    }
}

class Book {
    private String author, title, publishYear, copies, pages, volumes, number, fio, period;

    Book(String bookAuthor, String bookName, String year, String numcopy,
            String numpage, String numvol, String UDK, String FIO, String Period) {
        this.author = bookAuthor;
        this.title = bookName;
        this.publishYear = year;
        this.copies = numcopy;
        this.pages = numpage;
        this.volumes = numvol;
        this.number = UDK;
        this.fio = FIO;
        this.period = Period;
    }

    @Override
    public String toString() {
        return "Book [[author=" + this.author + ", title=" + this.title + ", publishYear=" + this.publishYear +
                "]\n      [copies=" + this.copies + ", pages=" + this.pages + ", volumes=" + this.volumes +
                "]\n      [number=" + this.number + ", fio=" + this.fio + ", period=" + this.period + "]]";
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getYear() {
        return Integer.parseInt(this.publishYear);
    }

    public String getRead() {
        return this.period;
    }

    public String getFIO() {
        return this.fio;
    }
}