package view;

import model.Command;

import java.util.Scanner;

public class SignupMenuView implements Menu {
    public static void run(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if(Command.EXIT.matches(input)) {
                break;
            }
            else if(Command.SHOW_CURRENT_MENU.matches(input)) {
                showCurrentMenu();
            }
            else if(Command.REGISTER_USER.matches(input)) {
                String username = Command.REGISTER_USER.getGroup(input, "username");
                String password = Command.REGISTER_USER.getGroup(input, "password");
                String email = Command.REGISTER_USER.getGroup(input, "email");
                registerUser(username, password, email);
            }
            else {
                SignupMenuMessages.invalidCommand();
            }
        }
    }
    public static void showCurrentMenu() {
        System.out.println("signup menu");
    }
    public static void registerUser(String username, String password, String email) {
        if(!isUsernameValid(username)) {
            SignupMenuMessages.usernameIsInvalid();
            return;
        }
        if(User.getUserByUsername(username) != null) {
            SignupMenuMessages.usernameIsAlreadyExist();
            return;
        }
        if(!Command.PASSWORD_LENGTH.matches(password)) {
            SignupMenuMessages.shortPassword();
            return;
        }
        if(!Command.PASSWORD_SPECIAL_CHARACTERS.matches(password)) {
            SignupMenuMessages.passwordSpecialCharacters();
            return;
        }
        if(!Command.PASSWORD_STARTS_WITH_LETTER.matches(password)) {
            SignupMenuMessages.passwordStartsWithLetter();
            return;
        }
        if(!Command.EMAIL_VALID_ENDING.matches(email)) {
            SignupMenuMessages.emailIsInvalid();
            return;
        }
        if(!Command.EMAIL_VALID_ADDRESS.matches(email)) {
            SignupMenuMessages.emailIsInvalid();
            return;
        }
        User user = new User(username, password, email);
        User.addUser(user);
        SignupMenuMessages.userCreatedSuccessfully();
    }
    public void exit() {
        System.exit(0);
    }
}
