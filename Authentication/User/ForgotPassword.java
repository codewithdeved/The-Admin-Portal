package Authentication.User;

import PortalKickOff.PortalLoading;
import java.util.Scanner;

import Authentication.Auth.LoginPassword;
import Authentication.LoginSystem;

public class ForgotPassword {

    private LoginSystem loginSystem;

    public ForgotPassword(LoginSystem loginSystem) {

        this.loginSystem = loginSystem;

    }

    public void resetPassword(LoginPassword loginPassword) {

        PortalLoading portalLoading = new PortalLoading(5, 600);

        Scanner scanner = new Scanner(System.in);

        String admin_password = loginPassword.getAdminPassword();

        System.out.print("\nAdmin, Please enter your new password: ");

        String admin_new_password = scanner.nextLine();

        while (admin_new_password.equals(admin_password)) {

            System.out.print(
                    "\nAdmin, your new password must be different from the current one. Please choose a new password: ");

            admin_new_password = scanner.nextLine();

        }

        System.out.print("\nAdmin, please confirm your new password: ");

        String confirm_admin_new_password = scanner.nextLine();

        while (!confirm_admin_new_password.equals(admin_new_password)) {

            System.out.print("\nAdmin, the new password does not match the confirmation. Please try again.");

            confirm_admin_new_password = scanner.nextLine();

        }

        portalLoading.loading();

        loginPassword.setAdminPassword(admin_new_password);

        loginSystem.resetAndLoginAgain();

    }

}