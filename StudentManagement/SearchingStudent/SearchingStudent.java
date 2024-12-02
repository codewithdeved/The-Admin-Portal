package StudentManagement.SearchingStudent;

import java.util.List;
import java.util.Scanner;

import PortalKickOff.PortalLoading;
import ServerMessages.ServerMessages;
import StudentManagement.ReadingStudent.Student;
import Table.Table;
import StudentManagement.DeletingStudent.DeletingStudent;

public class SearchingStudent {

    Table table = new Table();

    PortalLoading portalLoading = new PortalLoading(5, 600);

    private static final ServerMessages serverMessages = new ServerMessages();

    DeletingStudent deletingStudent = new DeletingStudent();

    private static final Scanner scanner = new Scanner(System.in);

    private int searchStudentID;

    private String searchStudent;

    public void searchOrDeleteStudent(List<Student> studentList) {

        while (true) {

            System.out.print(serverMessages.searchInstructionsToAdmin());

            String action = scanner.nextLine().toLowerCase();

            if ("exit".equals(action)) {
                System.out.println(serverMessages.searchProcessExcited());
                break;

            } else if ("search".equals(action)) {
                searchStudent(studentList);

            } else if ("delete".equals(action)) {

                DeletingStudent deletingStudent = new DeletingStudent();
                deletingStudent.deleteStudent(studentList, this);

            } else {
                System.out.println(serverMessages.searchInvalidInput());
            }
        }
    }

    public boolean searchAnotherStudent() {

        while (true) {

            System.out.print(serverMessages.searchForAnotherStudent());
            searchStudent = scanner.nextLine().toLowerCase();

            portalLoading.loading();

            if ("no".equals(searchStudent)) {
                return false;

            } else if ("exit".equals(searchStudent)) {
                return true;

            } else {
                System.out.println(serverMessages.invalidSearchInput());
            }

        }

    }

    public boolean studentSearched(List<Student> studentList, int searchStudentID) {

        boolean searchForStudent = false;

        for (Student student : studentList) {

            if (student.getId() == searchStudentID) {

                System.out.println(serverMessages.studentIDFound());

                table.Header();

                System.out.printf(
                        table.RowsAndColumns(),
                        student.getId(),
                        student.getName(),
                        student.getRollNumber(),
                        student.getProgram());

                table.Footer();

                searchForStudent = true;

                break;

            }

        }

        if (!searchForStudent) {
            System.out.println(serverMessages.studentIDNotFound());
        }

        return searchForStudent;
    }

    public void searchStudent(List<Student> studentList) {

        try {

            System.out.print(serverMessages.enterStudentID());
            searchStudentID = scanner.nextInt();

            scanner.nextLine();

            portalLoading.loading();

            if (!studentSearched(studentList, searchStudentID)) {
                System.out.println(serverMessages.studentIDNotFound());
            }

        } catch (Exception e) {
            System.out.println(serverMessages.numericStudentID());
            scanner.nextLine();
        }

    }

}