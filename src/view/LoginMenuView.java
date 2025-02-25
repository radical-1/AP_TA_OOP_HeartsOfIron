package view;

import controller.LoginMenuController;
import model.Command;
import model.Result;

import java.util.Scanner;

public class LoginMenuView implements Menu {

    public static void run(Scanner scanner) {
        while(true) {
            String input = scanner.nextLine().trim();
            if(Command.EXIT.matches(input)) {
                Menu.exit();
                break;
            }
            else if(Command.SHOW_CURRENT_MENU.matches(input)) {
                showCurrentMenu();
            }
            else if(Command.LOGIN_USER.matches(input)) {
                String username = Command.LOGIN_USER.getGroup(input, "username");
                String password = Command.LOGIN_USER.getGroup(input, "password");
                loginUser(username, password, scanner);
            }
            else if(Command.BACK.matches(input)) {
                SignupMenuView.run(scanner);
            }
            else if(Command.FORGET_PASSWORD.matches(input)) {
                String username = Command.FORGET_PASSWORD.getGroup(input, "username");
                String email = Command.FORGET_PASSWORD.getGroup(input, "email");
                forgetPassword(username, email, scanner);
            }
            else {
                Menu.invalidCommand();
            }
        }
    }
    public static void showCurrentMenu() {
        System.out.println("login menu");
    }
    public static void loginUser(String username, String password, Scanner scanner) {
        Result loginResult = LoginMenuController.login(username, password);
        System.out.println(loginResult.getMessage());
        if(loginResult.isValid()) {
            MainMenuView.run(scanner);
        }
    }
    public static void forgetPassword(String username, String email, Scanner scanner) {
        Result forgetPasswordResult = LoginMenuController.forgetPassword(username, email);
        System.out.println(forgetPasswordResult.getMessage());
    }
}
