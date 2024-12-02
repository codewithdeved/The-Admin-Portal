package Main;

import PortalKickOff.PortalLoading;
import PortalKickOff.PortalStart;

import Authentication.LoginSystem;
import StudentManagement.ReadingStudent.Student;

import ServerMessages.ServerMessages;

class Portal {

    public void portal(String[] args) {

        PortalLoading portalLoading = new PortalLoading(5, 600);
        portalLoading.loading();

        PortalStart portalStart = new PortalStart();
        portalStart.start();

        LoginSystem loginSystem = new LoginSystem();
        loginSystem.inputAdminCredentials();

        if (loginSystem.checkLoginStatus()) {
            Student.main(args);
        } else {
            ServerMessages serverMessages = new ServerMessages();
            System.out.println(serverMessages.adminLoginFirst());
        }

    }
}

public class Main {

    public static void main(String[] args) {

        Portal start = new Portal();
        start.portal(args);

    }

}