package Assignment_17;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RegistrationService service =
                new RegistrationService();

        try {

            // User input
            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            // Registration process
            boolean result =
                    service.registerUser(email, age);

            // Success message
            if (result) {

                System.out.println(
                        "Registration Successful!"
                );
            }
        }

        // Checked exception
        catch (InvalidEmailException e) {

            System.out.println(
                    "Email Error: " + e.getMessage()
            );
        }

        // Unchecked exception
        catch (UnderageException e) {

            System.out.println(
                    "Age Error: " + e.getMessage()
            );
        }

        // Invalid integer input
        catch (Exception e) {

            System.out.println(
                    "Invalid Input!"
            );
        }

        finally {

            sc.close();
        }
    }
}