package com.liligo.util;


import java.util.regex.Pattern;

import com.liligo.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtil {

    public void validatePhoneNumber(String phone) {
        var regexPattern = "^:\"\\d{2,3}\s\\d{3}|^\"\\+\\d{3}\s\\d{3}\s\\d{3}|^\\+\\d{1,3}\s\\d{2,4}\s\\d{3,4}\s\\d{3,4}$";

        var pattern = Pattern.compile(regexPattern);
        var matcher = pattern.matcher(phone);
        if (!matcher.matches()) {
            throw new ValidationException("error.airport-shuttle.validation-error", phone);
        }
    }

    public void validateEmail(String email) {
        var regexPattern = "^[a-zA-Z0-9\"\\._%+\\$\\-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}|^[a-zA-Z0-9\"\\._%+\\-]+@[a-zA-Z0-9.-]+\\.$";

        var pattern = Pattern.compile(regexPattern);
        var matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new ValidationException("error.airport-shuttle.validation-error", email);
        }

    }

}
