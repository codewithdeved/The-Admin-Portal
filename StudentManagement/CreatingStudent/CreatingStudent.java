package StudentManagement.CreatingStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import PortalKickOff.PortalLoading;
import ServerMessages.ServerMessages;

import StudentManagement.ReadingStudent.Student;
import StudentManagement.SearchingStudent.SearchingStudent;
import StudentManagement.UpdatingStudent.UpdatingStudent;

public class CreatingStudent {

    PortalLoading portalLoading = new PortalLoading(5, 600);

    private static final ServerMessages serverMessages = new ServerMessages();

    private static final Scanner scanner = new Scanner(System.in);

    private int studentID;
    private String studentName;
    private String studentRollNumber;
    private String studentProgram;

    private int studentCount = 0;

    private List<String> taskLog = new ArrayList<>();

    public void createStudent(List<Student> studentList) {

        while (true) {

            try {

                System.out.print(serverMessages.enterStudentID());
                studentID = scanner.nextInt();

                scanner.nextLine();

                if (isIdExists(studentList, studentID)) {
                    System.out.println(serverMessages.studentIDAlreadyExist());
                    continue;
                }

                System.out.print(serverMessages.enterStudentName());
                studentName = scanner.nextLine();

                System.out.print(serverMessages.enterStudentRollNo());
                studentRollNumber = scanner.nextLine();

                System.out.print(serverMessages.enterStudentProgram());
                studentProgram = scanner.nextLine();

                studentList.add(new Student(studentID, studentName, studentRollNumber, studentProgram));

                studentCount++;

                taskLog.add("Total students added: " + studentCount);

                System.out.println(serverMessages.studentRecordAdded());

                break;

            } catch (Exception e) {
                System.out.println(serverMessages.numericStudentID());
                scanner.nextLine();
            }

        }

    }

    public boolean createAnotherStudent() {

        while (true) {

            System.out.print(serverMessages.addAnotherStudent());
            String action = scanner.nextLine().toLowerCase();

            if ("exit".equals(action)) {

                displaySummary();

                return false;

            } else if ("start".equals(action)) {
                return true;

            } else {
                System.out.println(serverMessages.invalidStartInput());
            }

        }

    }

    public void displayNewStudentList(List<Student> studentList) {

        String action;

        do {

            System.out.print(serverMessages.adminLetsBegin());
            action = scanner.nextLine().toLowerCase();

            if ("start".equals(action)) {
                
                portalLoading.loading();

                do {
                    
                    System.out.println("\nPlease choose one of the following options to proceed:");
                    System.out.println("1. Create a new student record");
                    System.out.println("2. Read or delete an existing student record");
                    System.out.println("3. Update an existing student record");
                    System.out.println("4. Exit");

                    System.out.print("\nEnter 1 to create, 2 to read or delete, 3 to update, or 4 to exit: ");
                    String choice = scanner.nextLine();

                    portalLoading.loading();

                    switch (choice) {
                        
                        case "1":
                            createStudent(studentList);
                            break;

                        case "2":
                            SearchingStudent searchingStudent = new SearchingStudent();
                            searchingStudent.searchOrDeleteStudent(studentList);
                            taskLog.add("Performed search or delete operation.");
                            break;

                        case "3":
                            UpdatingStudent updatingStudent = new UpdatingStudent();
                            updatingStudent.updatingStudent(studentList);
                            taskLog.add("Performed update operation.");
                            break;

                        case "4":
                            displaySummary();
                            return;

                        default:
                            System.out.println(serverMessages.invalidStartInput());
                            break;

                    }

                    Student.displayStudents(studentList, true);

                } while (true);

            } else if ("exit".equals(action)) {

                System.out.println(serverMessages.noStudentAdded());
                return;

            } else {
                System.out.println(serverMessages.invalidStartInput());
            }

        } while (true);

    }

    public boolean isIdExists(List<Student> studentList, int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private void displaySummary() {

        System.out.println("\nSummary of tasks:");

        if (taskLog.isEmpty()) {

            System.out.println("\nAdmin, No tasks have been recorded for today. Stay productive!");

            System.out.println(serverMessages.noTasksAdmin());

        } else {

            for (String task : taskLog) {
                System.out.println("- " + task);
            }

            System.out.println(serverMessages.goodByeAdmin());

        }

    }

}