package controller;

import model.Command;
import model.User;

public class SignupMenuController {
    public boolean isValidUsername(String username) {
        return Command.VALID_USERNAME.matches(username);
    }

    public boolean doesUsernameExist(String username) {
        return User.getUserByUsername(username) != null;
    }
}