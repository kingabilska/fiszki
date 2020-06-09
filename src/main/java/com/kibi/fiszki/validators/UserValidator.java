package com.kibi.fiszki.validators;

import com.kibi.fiszki.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    UserDetailsManager userDetailsManager;

    public static String PASSWORD_RETYPE_ERROR = "error.password.not.equal";
    public static String USER_EXIST_ERROR = "error.user.exist";

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (!user.getPassword().equals(user.getPasswordConfirmation())) {
            errors.rejectValue("passwordConfirmation", PASSWORD_RETYPE_ERROR);
        }
        if (userDetailsManager.userExists(user.getUsername())) {
            errors.rejectValue("username", USER_EXIST_ERROR);
        }
    }
}
