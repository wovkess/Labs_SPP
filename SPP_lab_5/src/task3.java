import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class Person {

    private String name, surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Person(String name, String surname) {

        this.name = name;
        this.surname = surname;
    }

    public abstract void show();
}

class Abiturient extends Person {
    public Integer assessment;
    private Faculty facultet; // Ассоциация
    private ArrayList<Exams> exams; // Ассоциация
    private Exams exam = new Exams("Show");;

    Abiturient(String name, String surname, String Facultet, ArrayList<Exams> exams) {
        super(name, surname);
        this.facultet = new Faculty(name, surname, Facultet); // Композиция
        this.exams = exams; // Агрегация
    }

    Abiturient(String name, String surname) {
        super(name, surname);
    }

    public void show() {
        System.out.println("\nAbiturient: " + super.getSurname() + " " + super.getName());
    }

    public void showResult() {
        System.out.println("Abiturient " + super.getSurname() + " " + super.getName() +
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

class Exams implements Printable {
    private String exam;
    static private ArrayList<Exams> exams = new ArrayList<Exams>();

    Exams(String Exam) {
        this.exam = Exam;
    }

    void setExams(Exams oun, Exams two) {
        exams.add(oun);
        exams.add(two);
    }

    ArrayList<Exams> getExams() {
        return exams;
    }

    public String show() {
        return exams.get(0).exam + " and " + exams.get(1).exam;
    }
}

class Teacher {
    public int Assessment;

    Teacher(Integer assessment) {
        this.Assessment = assessment;
    }

    public void show() {
        System.out.println("The teacher gave the grade " + this.Assessment);
    }
}

class Assessment {
    private int max = 10;
    private int min = 0;

    Integer getAssessment() {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}

interface Printable {

    String show();
}

public class task3 {
    public static void main(String[] args) {
        HashMap<String, Integer> studentsResult = new HashMap<String, Integer>();
        Abiturient Ab_1 = new Abiturient("Petrov", "Ivan");
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

        Teacher Tch_1 = new Teacher(assessment.getAssessment());
        Ab_1.assessment = Tch_1.Assessment;
        Tch_1.show();
        studentsResult.put(Ab_1.getSurname(), Ab_1.assessment);

        Abiturient Ab_2 = new Abiturient("Ivanov", "Petr");
        Ab_2.show();

        Ab_2 = new Abiturient(Ab_2.getName(), Ab_2.getSurname(), Facultet, exams);
        Faculty facultet2 = new Faculty(Ab_2.getName(), Ab_2.getSurname(), Facultet);
        facultet2.showFacult();
        Ab_2.showResult();

        Teacher Tch_2 = new Teacher(assessment.getAssessment());
        Ab_2.assessment = Tch_2.Assessment;
        Tch_2.show();
        studentsResult.put(Ab_2.getSurname(), Ab_2.assessment);

        System.out.println("\nStudents who passed the exams");
        for (Map.Entry<String, Integer> entry : studentsResult.entrySet())
            if (entry.getValue() >= 4)
                System.out.println(entry.getKey());
    }
}