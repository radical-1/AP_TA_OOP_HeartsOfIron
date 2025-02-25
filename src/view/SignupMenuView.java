package view;

import controller.SignupMenuController;
import model.Command;
import model.Result;

import java.util.Scanner;

public class SignupMenuView implements Menu {
    public static void run(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if(Command.EXIT.matches(input)) {
                Menu.exit();
            }
            else if(Command.SHOW_CURRENT_MENU.matches(input)) {
                showCurrentMenu();
            }
            else if(Command.REGISTER_USER.matches(input)) {
                String username = Command.REGISTER_USER.getGroup(input, "username");
                String password = Command.REGISTER_USER.getGroup(input, "password");
                String email = Command.REGISTER_USER.getGroup(input, "email");
                registerUser(username, password, email, scanner);
            }
            else if(Command.GO_TO_LOGIN_MENU.matches(input)) {
                LoginMenuView.run(scanner);
            }
            else {
                Menu.invalidCommand();
            }
        }
    }
    public static void showCurrentMenu() {
        System.out.println("signup menu");
    }
    public static void registerUser(String username, String password, String email, Scanner scanner) {
        Result registerResult = SignupMenuController.register(username, password, email);
        System.out.println(registerResult.getMessage());
        if(registerResult.isValid()) {
            LoginMenuView.run(scanner);
        }
    }
}
