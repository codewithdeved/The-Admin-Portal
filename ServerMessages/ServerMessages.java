package ServerMessages;

public class ServerMessages {

    public String adminLoginFirst() {
        return "Admin, you need to log in first to access the student dashboard.";
    }

    public String processRequest() {
        return "Admin, please wait while we process your request.";
    }

    public String defaultStudentList() {
        return "\nAdmin, Here's the list of all students enrolled in Spring 2024 Software Engineering Technology Program.";
    }

    public String updatedStudentList() {
        return "\nAdmin, Here's the updated list of all students enrolled in Spring 2024 Software Engineering Technology Program.";
    }

    public String adminLetsBegin() {
        return "\nAdmin, Please type \"start\" to proceed or \"exit\" to terminate the process. ";
    }

    public String invalidStartInput() {
        return "\nAdmin, invalid input. Please type 'Start' to continue or 'Done' to exit.";
    }

    public String enterStudentID() {
        return "\nAdmin, Enter the student ID: ";
    }

    public String enterStudentSearchID() {
        return "\nAdmin, Enter the student ID you want to search for: ";
    }

    public String enterStudentDeleteID() {
        return "\nAdmin, Enter the ID of the student you want to delete: ";
    }

    public String studentDeleted() {
        return "\nAdmin, Student Deleted.";
    }

    public String studentNotDeleted() {
        return "\nAdmin, Student Not Deleted.";
    }

    public String studentIDAlreadyExist() {
        return "\nAdmin, this Student ID already exists. Please try a unique ID.";
    }

    public String numericStudentID() {
        return "\nInvalid input. Please enter a numeric Student ID.";
    }

    public String studentIDFound() {
        return "\nAdmin, Student ID Found:";
    }

    public String studentIDNotFound() {
        return "\nAdmin, Student ID Not Found:";
    }

    public String enterStudentName() {
        return "\nAdmin, Enter the student Name: ";
    }

    public String enterStudentRollNo() {
        return "\nAdmin, Enter the student Roll #: ";
    }

    public String enterStudentProgram() {
        return "\nAdmin, Enter the student enrolled Program: ";
    }

    public String studentRecordAdded() {
        return "\nAdmin, the student record has been successfully added.";
    }

    public String addAnotherStudent() {
        return "\nAdmin, would you like to add another student? Type \"start\" to continue or \"exit\" to exit: ";
    }

    public String processOfAddingStudentCompleted() {
        return "The process of adding student records has been completed. Thank you for your time.";
    }

    public String noStudentAdded() {
        return "\nAdmin, no students were added. Thank you for your time.";
    }

    public String searchInvalidInput() {
        return "\nInvalid input. Please type \"search\" to search, \"delete\" to delete a student, or \"exit\" to exit.";
    }

    public String searchProcessExcited() {
        return "\nAdmin, the search or delete process has exited. Thank you for your time.";
    }

    public String searchInstructionsToAdmin() {
        return "\nAdmin, Type \"search\" to begin searching, \"delete\" to delete a student, or \"exit\" to exit: ";
    }

    public String searchForAnotherStudent() {
        return "\nAdmin, Do you want to search or delete another student? (yes/no): ";
    }

    public String invalidSearchInput() {
        return "\nAdmin, Invalid input. Please type \"search\" to search, \"delete\" to delete a student, or \"exit\" to exit.";
    }

    public String adminWantsToDelete() {
        return "\nAdmin, Do you want to delete this student? (yes/no): ";
    }

    public String adminUpdatingDetails() {
        return "\nAdmin, Updating details for student ID: ";
    }

    public String adminUpdatedSuccessfully() {
        return "\nAdmin, Student record updated successfully.";
    }

    public String goodByeAdmin() {
        return "\nThank you for managing student records efficiently today. Your attention to detail and commitment to maintaining\naccurate records play a critical role in the success of our system."
                + "\n\n" +
                "If you need further assistance or have additional tasks, feel free to start a new session. Keep up the excellent\nwork, and have a productive day ahead!"
                + "\n\n" +
                "Best regards,\n" +
                "Sir Syed University of Engineering & Technology.\n";
    }

    public String noTasksAdmin() {
        return "\nIt seems no tasks were completed today. Remember, consistent efforts are key to maintaining an organized and efficient\nstudent records system."
                + "\n\n" +
                "We encourage you to review pending tasks and prioritize them in your next session. Your role is vital to the smooth\nfunctioning of our system, and every contribution you make helps us move forward."
                + "\n\n" +
                "Best regards,\n" +
                "Sir Syed University of Engineering & Technology.\n";
    }

}