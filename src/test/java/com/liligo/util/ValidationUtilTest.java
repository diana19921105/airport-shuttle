package com.liligo.util;

import com.liligo.exception.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidationUtilTest {

    private ValidationUtil validationUtil;

    @BeforeEach
    void init() {
        validationUtil = new ValidationUtil();
    }

    @ParameterizedTest
    @CsvSource({ ":\"48 443", "+55 560 220 2355", "+7 753 280 1345", "+227 588 334 0759", "+36 30 385 9631", "\"+242 683 223" })
    void validatePhoneNumberTest_ReturnTrue(String phoneNumber) {
        assertDoesNotThrow(() -> validationUtil.validatePhoneNumber(phoneNumber));
    }

    @ParameterizedTest
    @CsvSource({ "++12 345 678", "!\"77 567", "+ 567 9876 12" })
    void validatePhoneNumber_ThrowsException(String phoneNumber) {
        assertThrows(ValidationException.class, () -> validationUtil.validatePhoneNumber(phoneNumber));
    }

    @ParameterizedTest
    @CsvSource({ "mdelves19@ca.gov", "\"ddeem@usda.", "ymoninik@about.me", "msmithson3@reverbnation.com", "john1$@doe.com" })
    void validateEmail_ReturnTrue(String email) {
        assertDoesNotThrow(() -> validationUtil.validateEmail(email));
    }

    @ParameterizedTest
    @CsvSource({ "mdelves19ca.gov" })
    void validateEmail_ThrowsException(String email) {
        assertThrows(ValidationException.class, () -> validationUtil.validateEmail(email));
    }

}
