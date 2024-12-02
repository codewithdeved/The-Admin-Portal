package StudentManagement.ReadingStudent;

import java.util.ArrayList;
import java.util.List;

import Table.Table;

import ServerMessages.ServerMessages;

import StudentManagement.CreatingStudent.CreatingStudent;

class StudentList {

    public List<Student> getStudentList() {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(1, "SARIM", "001", "Software Engineering Technology"));
        studentList.add(new Student(2, "WAHAJ", "002", "Software Engineering Technology"));
        studentList.add(new Student(3, "MUSAWIR", "003", "Software Engineering Technology"));
        studentList.add(new Student(4, "AHSAN", "004", "Software Engineering Technology"));
        studentList.add(new Student(5, "S.M HAMZA", "005", "Software Engineering Technology"));
        studentList.add(new Student(6, "TAYYAB", "006", "Software Engineering Technology"));
        studentList.add(new Student(7, "ALISHBA AHMED", "007", "Software Engineering Technology"));
        studentList.add(new Student(8, "SAMAN ZAHRA", "008", "Software Engineering Technology"));
        studentList.add(new Student(9, "AFSAN BALOCH", "009", "Software Engineering Technology"));
        studentList.add(new Student(10, "ALISHBA IQBAL", "010", "Software Engineering Technology"));
        studentList.add(new Student(11, "NARGIS", "011", "Software Engineering Technology"));
        studentList.add(new Student(12, "ALISHBA KHAN", "012", "Software Engineering Technology"));
        studentList.add(new Student(13, "MUHAMMAD ZAID", "013", "Software Engineering Technology"));
        studentList.add(new Student(14, "IRFAN RASOOL", "014", "Software Engineering Technology"));
        studentList.add(new Student(15, "MUHAMMAD OWAIS", "015", "Software Engineering Technology"));
        studentList.add(new Student(16, "NASIR KHAN", "016", "Software Engineering Technology"));
        studentList.add(new Student(17, "RAJ BHAGAT", "017", "Software Engineering Technology"));
        studentList.add(new Student(18, "ZAID", "018", "Software Engineering Technology"));
        studentList.add(new Student(19, "ABDUL WASAY", "019", "Software Engineering Technology"));
        studentList.add(new Student(20, "HASNAIN", "020", "Software Engineering Technology"));
        studentList.add(new Student(21, "ZAIN", "021", "Software Engineering Technology"));

        return studentList;

    }

}

public class Student {

    private int id;
    private String name;
    private String rollNumber;
    private String program;

    public Student(int id, String name, String rollNumber, String program) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
        this.program = program;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String toString() {
        return "Student { Id: " + id + ", Name: " + name + ", Roll #: " + rollNumber + ", Program: " + program + " }";
    }

    public static void main(String[] args) {

        StudentList studentListManager = new StudentList();

        List<Student> studentList = studentListManager.getStudentList();

        displayStudents(studentList, false);
        
        CreatingStudent creatingStudent = new CreatingStudent();
        
        creatingStudent.displayNewStudentList(studentList);

    }

    public static void displayStudents(List<Student> studentList, boolean isUpdated) {

        ServerMessages serverMessages = new ServerMessages();

        System.out.println(isUpdated ? serverMessages.updatedStudentList() : serverMessages.defaultStudentList());

        Table table = new Table();

        table.Header();

        for (Student student : studentList) {
            System.out.printf(
                    table.RowsAndColumns(),
                    student.getId(),
                    student.getName(),
                    student.getRollNumber(),
                    student.getProgram());
        }

        table.Footer();

    }

}