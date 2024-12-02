package Authentication.Auth;

import PortalKickOff.PortalLoading;
import Authentication.User.ForgotPassword;
import java.util.Scanner;

public class LoginPassword {

    private String admin_password = "admin123";

    public void setAdminPassword(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdminPassword() {
        return admin_password;
    }

    public void inputAdminPassword(ForgotPassword forgotPassword) {

        PortalLoading portalLoading = new PortalLoading(5, 600);

        Scanner scanner = new Scanner(System.in);
        String input_password;

        while (true) {

            System.out.print("\nDear Admin, please enter your password here: ");
            input_password = scanner.nextLine();

            if (input_password.isEmpty()) {
                System.err.println("\nError: The password field is required. Please enter a valid password to proceed.");
                continue;
            }

            if (input_password.equals(getAdminPassword())) {
                
                portalLoading.loading();
                break;

            } else {

                System.err.println("\nIncorrect password. Please check your credentials and try again.");
                System.out.println("\nTo proceed, please select one of the following options:");
                System.out.println("1. Retry entering the correct password.");
                System.out.println("2. Reset your password.");

                System.out.print("\nPlease enter 1 to retry or 2 to reset: ");
                int choice;

                try {

                    choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 1) {
                        continue;
                    } else if (choice == 2) {
                        forgotPassword.resetPassword(this);
                        break;
                    } else {
                        System.out.println("\nInvalid selection. Please enter 1 to retry or 2 to reset.");
                    }

                } catch (Exception e) {
                    System.err.println("\nInvalid input. Please enter a number (1 or 2).");
                    scanner.nextLine();
                }

            }

        }

    }

}