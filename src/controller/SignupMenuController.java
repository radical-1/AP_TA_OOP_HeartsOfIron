package controller;

import model.Command;
import model.Result;
import model.User;

public class SignupMenuController {
    public static Result register(String username, String password, String email) {
        Result usernameValidation = validateUsername(username);
        if(!usernameValidation.isValid()) {
            return usernameValidation;
        }

        Result passwordValidation = passwordValidation(password);
        if(!passwordValidation.isValid()) {
            return passwordValidation;
        }

        Result emailValidation = emailValidation(email);
        if(!emailValidation(email).isValid()) {
            return emailValidation;
        }
        new User(username, password, email);
        return new Result(true, "user registered successfully");
    }

    private static Result validateUsername(String username) {
        if(!Command.VALID_USERNAME.matches(username)) {
            return new Result(false, "invalid username");
        }
        if(!Command.USERNAME_STARTS_WITH_LETTER.matches(username)) {
            return new Result(false, "invalid username");
        }
        if(User.getUserByUsername(username) != null) {
            return new Result(false, "username is already taken");
        }
        return new Result(true, null);
    }
    private static Result passwordValidation(String password) {
        if(!Command.PASSWORD_LENGTH.matches(password)) {
            return new Result(false, "invalid length");
        }

        if(!Command.WITHOUT_WHITESPACE.matches(password)) {
            return new Result(false, "don't use whitespace in password");
        }
        if(!Command.PASSWORD_STARTS_WITH_LETTER.matches(password)) {
            return new Result(false, "password must start with English letters");
        }
        if(!Command.PASSWORD_SPECIAL_CHARACTERS.matches(password)) {
            return new Result(false, "password doesn't have special characters");
        }
        return new Result(true, null);
    }

    private static Result emailValidation(String email) {
        if(!Command.EMAIL_VALID_ADDRESS.matches(email)) {
            return new Result(false, "invalid email format");
        }
        return new Result(true, null);
    }
}