package view;

import model.Command;
import model.User;

import java.util.Scanner;

public class MainMenuView implements Menu {
    public static void run(Scanner scanner) {
        while(true) {
            String input = scanner.nextLine().trim();
            if(Command.EXIT.matches(input)) {
                Menu.exit();
            }
            else if(Command.SHOW_CURRENT_MENU.matches(input)) {
                showCurrentMenu();
            }
            else if(Command.LOGOUT.matches(input)) {
                logout(scanner);
                break;
            } else if (Command.GO_TO_LEADERBOARD.matches(input)) {
                LeaderboardView.run(scanner);
            } else {
                Menu.invalidCommand();
            }
        }
    }

    public static void showCurrentMenu() {
        System.out.println("main menu");
    }
    public static void logout(Scanner scanner) {
        User.logout();
    }
}
