package Test.Assignment_17;

// RegistrationServiceTest.java
import Assignment_17.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationServiceTest {

    private RegistrationService service;

    // Runs before every test
    @BeforeEach
    void setup() {

        service = new RegistrationService();
    }

    // Successful registration test
    @Test
    void testValidRegistration()
            throws InvalidEmailException {

        boolean result =
                service.registerUser(
                        "user@gmail.com",
                        22
                );

        assertTrue(result);
    }

    // Invalid email format test
    @Test
    void testInvalidEmailFormat() {

        assertThrows(
                InvalidEmailException.class,

                () -> {
                    service.registerUser(
                            "wrongemail",
                            22
                    );
                }
        );
    }

    // Empty email test
    @Test
    void testEmptyEmail() {

        assertThrows(
                InvalidEmailException.class,

                () -> {
                    service.registerUser(
                            "",
                            22
                    );
                }
        );
    }

    // Null email test
    @Test
    void testNullEmail() {

        assertThrows(
                InvalidEmailException.class,

                () -> {
                    service.registerUser(
                            null,
                            22
                    );
                }
        );
    }

    // Underage user test
    @Test
    void testUnderageUser() {

        assertThrows(
                UnderageException.class,

                () -> {
                    service.registerUser(
                            "user@gmail.com",
                            16
                    );
                }
        );
    }
}
