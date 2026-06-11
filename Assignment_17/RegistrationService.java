package Assignment_17;

// RegistrationService.java

import java.util.regex.Pattern;

public class RegistrationService {

    // Email regex pattern
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public boolean registerUser(String email, int age)
            throws InvalidEmailException {

        // Internal assertion
        assert age >= 0 : "Age cannot be negative";

        // Null or empty check
        if (email == null || email.trim().isEmpty()) {

            throw new InvalidEmailException(
                    "Email cannot be null or empty"
            );
        }

        // Regex validation
        if (!Pattern.matches(EMAIL_REGEX, email)) {

            throw new InvalidEmailException(
                    "Invalid email format: " + email
            );
        }

        // Age validation
        if (age < 18) {

            throw new UnderageException(
                    "User must be at least 18 years old. Given age: " + age
            );
        }

        return true;
    }
}
