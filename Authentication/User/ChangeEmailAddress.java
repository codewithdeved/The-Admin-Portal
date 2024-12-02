package Authentication.User;

import PortalKickOff.PortalLoading;
import java.util.Scanner;

import Authentication.Auth.LoginEmail;
import Authentication.LoginSystem;

public class ChangeEmailAddress {

    private LoginSystem loginSystem;

    public ChangeEmailAddress(LoginSystem loginSystem) {

        this.loginSystem = loginSystem;

    }

    public void changeEmailAddress(LoginEmail loginEmail) {

        PortalLoading portalLoading = new PortalLoading(5, 600);

        Scanner scanner = new Scanner(System.in);

        String admin_email = loginEmail.getAdminEmail();

        String admin_existing_email = "";

        while (admin_existing_email.isEmpty() || !admin_existing_email.equals(admin_email)) {

            System.out.print("\nPlease enter your current email address to proceed: ");

            admin_existing_email = scanner.nextLine();

            if (admin_existing_email.isEmpty()) {

                System.err.println("\nError: The email field is required. Please enter your current email address.");

            }

            if (!admin_existing_email.equals(admin_email)) {

                System.err.println("\nError: The provided email address does not match your current email address.");

            }

        }

        if (admin_existing_email.equals(admin_email)) {

            String admin_new_email = "";

            while (admin_new_email.isEmpty()) {

                System.out.print("\nAdmin, Please enter your new email address: ");

                admin_new_email = scanner.nextLine();

                if (admin_new_email.isEmpty()) {

                    System.err.println("Error: The new email address cannot be empty. Please provide a valid email.");

                    continue;

                }

                if (isValidEmail(admin_new_email)) {

                    loginEmail.setAdminEmail(admin_new_email);

                    portalLoading.loading();

                    System.out.println("\nAdmin, your email address has been successfully updated.");

                    this.loginSystem.inputAdminCredentials();

                    return;

                } else {

                    System.err.println("\nInvalid email format. Please enter a valid email address.");

                    admin_new_email = "";

                }

            }

        } else {

            System.out.println("\nAdmin, Your current email address is incorrect.");

        }

    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".") && email.indexOf("@") < email.indexOf(".");
    }

}