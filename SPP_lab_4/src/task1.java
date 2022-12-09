import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Abiturient implements Printable {
    private String Name, Surname;
    public Integer assessment;
    private Faculty facultet;
    private ArrayList<Exams> exams;
    private Exams exam = new Exams("Show");;

    Abiturient(String name, String surname, String Facultet, ArrayList<Exams> exams) {
        this.Name = name;
        this.Surname = surname;
        this.facultet = new Faculty(name, surname, Facultet);
        this.exams = exams; // Агрегация
    }

    Abiturient(String name, String surname) {
        this.Name = name;
        this.Surname = surname;
    }

    String getName() {
        return this.Name;
    }

    String getSurname() {
        return this.Surname;
    }

    public void show() {
        System.out.println("\nAbiturient: " + this.Surname + " " + this.Name);
    }

    public void showResult() {
        System.out.println("Abiturient " + this.Surname + " " + this.Name +
                " of faculty " + this.facultet.getFaculty() + " passed exams " + exam.show());
    }
}

class Faculty extends Abiturient {
    private String Namefacult, name, surname;

    Faculty(String name, String surname, String namefacult) {
        super(name, surname);
        this.name = name;
        this.surname = surname;
        this.Namefacult = namefacult;
    }

    String getFaculty() {
        return this.Namefacult;
    }

    void showFacult() {
        System.out.println("Abiturient " + this.name + " "
                + this.surname + " registered with the faculty: " + this.Namefacult);
    }
}

class Exams {
    private String exam;
    static private ArrayList<Exams> exams = new ArrayList<Exams>();

    Exams(String Exam) {
        this.exam = Exam;
    }

    void setExams(Exams one, Exams two) {
        exams.add(one);
        exams.add(two);
    }

    ArrayList<Exams> getExams() {
        return exams;
    }

    String show() {
        return exams.get(0).exam + " and " + exams.get(1).exam;
    }
}

class Teacher extends Abiturient {
    private String name, surname;
    public int Assessment;

    Teacher(String name, String surname, Integer assessment) {
        super(name, surname);
        this.name = name;
        this.surname = surname;
        this.Assessment = assessment;
    }

    public void show() {
        System.out.println("The teacher gave the grade " + this.Assessment
                + " for student " + this.name + " " + this.surname);
    }
}

class Assessment { // rand point
    private int max = 10;
    private int min = 0;

    Integer getAssessment() {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}

interface Printable {

    void show();
}

public class task1 {
    public static void main(String[] args) {
        HashMap<String, Integer> studentsResult = new HashMap<String, Integer>();
        Abiturient Ab_1 = new Abiturient("Ivan", "Petrov");
        Ab_1.show();

        String Facultet = "FEIS";
        Exams math = new Exams("language");
        Exams history = new Exams("literature");
        Assessment assessment = new Assessment();
        math.setExams(math, history);
        ArrayList<Exams> exams = history.getExams();

        Ab_1 = new Abiturient(Ab_1.getName(), Ab_1.getSurname(), Facultet, exams);
        Faculty facultet = new Faculty(Ab_1.getName(), Ab_1.getSurname(), Facultet);
        facultet.showFacult();
        Ab_1.showResult();

        Teacher Tch_1 = new Teacher(Ab_1.getName(), Ab_1.getSurname(), assessment.getAssessment());
        Ab_1.assessment = Tch_1.Assessment;
        Tch_1.show();
        studentsResult.put(Ab_1.getSurname(), Ab_1.assessment);

        Abiturient Ab_2 = new Abiturient("Petr", "Ivanov");
        Ab_2.show();

        Ab_2 = new Abiturient(Ab_2.getName(), Ab_2.getSurname(), Facultet, exams);
        Faculty facultet2 = new Faculty(Ab_2.getName(), Ab_2.getSurname(), Facultet);
        facultet2.showFacult();
        Ab_2.showResult();

        Teacher Tch_2 = new Teacher(Ab_2.getName(), Ab_2.getSurname(), assessment.getAssessment());
        Ab_2.assessment = Tch_2.Assessment;
        Tch_2.show();
        studentsResult.put(Ab_2.getSurname(), Ab_2.assessment);

        System.out.println("\nStudents who passed the exams");
        for (Map.Entry<String, Integer> entry : studentsResult.entrySet())
            if (entry.getValue() >= 4)
                System.out.println(entry.getKey());
    }
}