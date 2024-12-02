package StudentManagement.DeletingStudent;

import java.util.List;
import java.util.Scanner;

import PortalKickOff.PortalLoading;
import ServerMessages.ServerMessages;

import StudentManagement.ReadingStudent.Student;
import StudentManagement.SearchingStudent.SearchingStudent;

public class DeletingStudent {

    PortalLoading portalLoading = new PortalLoading(5, 600);

    private static final ServerMessages serverMessages = new ServerMessages();

    private static final Scanner scanner = new Scanner(System.in);

    private int searchStudentID;

    public void deleteStudent(List<Student> studentList, SearchingStudent searchingStudent) {

        try {

            System.out.print(serverMessages.enterStudentID());
            searchStudentID = scanner.nextInt();

            scanner.nextLine();

            portalLoading.loading();

            if (searchingStudent.studentSearched(studentList, searchStudentID)) {

                System.out.print(serverMessages.adminWantsToDelete());
                String confirmation = scanner.nextLine().toLowerCase();

                if ("yes".equals(confirmation)) {

                    studentList.removeIf(student -> student.getId() == searchStudentID);
                    System.out.println(serverMessages.studentDeleted());

                    reindexStudents(studentList);

                    Student.displayStudents(studentList, true);

                } else {
                    System.out.println(serverMessages.studentNotDeleted());
                }

            } else {
                System.out.println(serverMessages.studentIDNotFound());
            }

        } catch (Exception e) {
            System.out.println(serverMessages.numericStudentID());
            scanner.nextLine();
        }

    }

    private void reindexStudents(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).setId(i + 1);
        }
    }

}