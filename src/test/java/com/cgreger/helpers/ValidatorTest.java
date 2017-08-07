package com.cgreger.helpers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by katana on 4/24/17.
 */
public class ValidatorTest {

    private Validator validator = new Validator();

    @Test
    public void validateValidEmail() throws Exception {

        String email = "test@mailinator.com";
        Boolean isValid = validator.validateEmail(email);

        assertTrue(isValid);
    }

    @Test
    public void validateInvalidEmail() throws Exception {

        String email = "notAnEmail[]##....";
        Boolean isValid = validator.validateEmail(email);

        assertFalse(isValid);

    }

    @Test
    public void validateValidPassword() throws Exception {

        String password = "password";
        String repeatPassword = "password";

        Boolean isValid = validator.validatePassword(password, repeatPassword);

        assertTrue(isValid);

    }

    @Test
    public void validateInvalidPassword() throws Exception {

        String password = "pass";
        String repeatPassword = "pass";

        Boolean isValid = validator.validatePassword(password, repeatPassword);

        assertFalse(isValid);

        password = "password";
        repeatPassword = "pass";

        isValid = validator.validatePassword(password, repeatPassword);

        assertFalse(isValid);

    }

    @Test
    public void validateInvalidAPIKey() throws Exception {

        String apiKey = "SHOULD-BE-INVALID";
        Boolean isValid = validator.validateAPIKey(apiKey);
        assertFalse(isValid);

    }

    @Test
    public void validateValidAPIKey() throws Exception {

        String apiKey = "92C3C958-6838-594B-9A84-1653AA58255C657485A1-9337-446C-9981-7C9C8A1EED29";
        Boolean isValid = validator.validateAPIKey(apiKey);
        assertTrue(isValid);

    }

    @Test
    public void validateValidWithWrongPermissionsAPIKey() throws Exception {

        String apiKey = "";
        Boolean isValid = validator.validateAPIKey(apiKey);
        assertTrue(!isValid);

    }

}