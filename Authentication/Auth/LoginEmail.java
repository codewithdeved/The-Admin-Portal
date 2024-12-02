package Authentication.Auth;

import java.util.Scanner;
import Authentication.User.ChangeEmailAddress;

public class LoginEmail {

    private String admin_email = "admin@gmail.com";

    public void setAdminEmail(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdminEmail() {
        return admin_email;
    }

    public boolean inputAdminEmail(ChangeEmailAddress changeEmailAddress) {

        Scanner scanner = new Scanner(System.in);
        String input_email;

        while (true) {

            System.out.print("\nDear Admin, please enter your email address: ");
            input_email = scanner.nextLine();

            if (input_email.isEmpty()) {
                System.err
                        .println("\nError: The email field is required. Please enter a valid email address to proceed.");
                continue;
            }

            if (input_email.equalsIgnoreCase(getAdminEmail())) {

                return true;

            } else {

                System.err.println(
                        "\nThe email address you entered could not be verified. Please ensure the email is correct.");
                System.out.println("\nTo proceed, please select one of the following options:");
                System.out.println("1. Retry entering the correct email address.");
                System.out.println("2. Change your email address.");

                System.out.print("\nPlease enter 1 to retry or 2 to change: ");
                int choice;

                try {

                    choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 1) {
                        continue;
                    } else if (choice == 2) {
                        changeEmailAddress.changeEmailAddress(this);
                        return true;
                    } else {
                        System.out.println("\nInvalid selection. Please enter 1 to retry or 2 to change.");
                    }

                } catch (Exception e) {
                    System.err.println("\nInvalid input. Please enter a number (1 or 2).");
                    scanner.nextLine();
                }

            }

        }

    }

}