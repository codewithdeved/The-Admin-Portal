package StudentManagement.UpdatingStudent;

import java.util.List;
import java.util.Scanner;

import PortalKickOff.PortalLoading;
import ServerMessages.ServerMessages;
import StudentManagement.ReadingStudent.Student;

public class UpdatingStudent {

    PortalLoading portalLoading = new PortalLoading(5, 600);

    private static final ServerMessages serverMessages = new ServerMessages();

    private static final Scanner scanner = new Scanner(System.in);

    private int studentID;
    private String studentName;
    private String studentRollNumber;
    private String studentProgram;

    public void updatingStudent(List<Student> studentList) {

        System.out.print(serverMessages.enterStudentID());
        studentID = scanner.nextInt();

        scanner.nextLine();

        Student studentToUpdate = null;

        for (Student student : studentList) {
            if (student.getId() == studentID) {
                studentToUpdate = student;
                break;
            }
        }

        if (studentToUpdate == null) {
            System.out.println(serverMessages.studentIDNotFound());
            return;
        }

        System.out.println(serverMessages.adminUpdatingDetails() + studentID);

        System.out.print("\nEnter new name (current: " + studentToUpdate.getName() + "): ");
        studentName = scanner.nextLine();

        studentToUpdate.setName(studentName.isEmpty() ? studentToUpdate.getName() : studentName);

        System.out.print("\nEnter new roll number (current: " + studentToUpdate.getRollNumber() + "): ");
        studentRollNumber = scanner.nextLine();

        studentToUpdate
                .setRollNumber(studentRollNumber.isEmpty() ? studentToUpdate.getRollNumber() : studentRollNumber);

        System.out.print("\nEnter new program (current: " + studentToUpdate.getProgram() + "): ");
        studentProgram = scanner.nextLine();

        studentToUpdate.setProgram(studentProgram.isEmpty() ? studentToUpdate.getProgram() : studentProgram);

        portalLoading.loading();

        System.out.println(serverMessages.adminUpdatedSuccessfully());

    }

}