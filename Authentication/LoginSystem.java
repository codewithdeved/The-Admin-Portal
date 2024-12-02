package Authentication;

import Authentication.Auth.LoginEmail;
import Authentication.User.ChangeEmailAddress;
import Authentication.Auth.LoginPassword;
import Authentication.User.ForgotPassword;

public class LoginSystem {

    private final LoginEmail loginEmail = new LoginEmail();

    private final LoginPassword loginPassword = new LoginPassword();

    private final ForgotPassword forgotPassword = new ForgotPassword(this);

    private final ChangeEmailAddress changeEmailAddress = new ChangeEmailAddress(this);

    private boolean isAlreadyLoggedIn = false;

    public void inputAdminCredentials() {

        boolean isEmailValid = loginEmail.inputAdminEmail(changeEmailAddress);

        if (isEmailValid) {

            if (!isAlreadyLoggedIn) {

                loginPassword.inputAdminPassword(forgotPassword);

                isAlreadyLoggedIn = true;

                System.out.println("\nLogin successful. Welcome, Admin.");

            }

        } else {

            System.err.println("\nThe email address you entered is invalid. Please verify and try again.");

        }

    }

    public void resetAndLoginAgain() {

        isAlreadyLoggedIn = false;

        System.out.println(
                "\nAdmin, your password has been successfully reset. You can now log in using your new password.");

        boolean isEmailValid = loginEmail.inputAdminEmail(changeEmailAddress);

        if (isEmailValid) {

            loginPassword.inputAdminPassword(forgotPassword);

            isAlreadyLoggedIn = true;

        }

    }

    public boolean checkLoginStatus() {
        return isAlreadyLoggedIn;
    }

}