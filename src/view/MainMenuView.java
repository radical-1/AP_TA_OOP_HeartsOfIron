package view;

import controller.MainMenuController;
import model.Command;
import model.Result;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenuView implements Menu {
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
            else if (Command.GO_TO_LEADERBOARD.matches(input)) {
                LeaderboardView.run(scanner);
            }
            else if(Command.LOGOUT.matches(input)) {
                logout(scanner);
            }
            else if (Command.PLAY.matches(input)) {
                ArrayList<String> usernames = new ArrayList<>();
                Matcher matcher = Command.PLAY.getMatcher(input);
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    if (matcher.group(i) != null)
                        usernames.add(matcher.group(i));
                }
                play(usernames, scanner);
            }
            else {
                Menu.invalidCommand();
            }
        }
    }

    private static void showCurrentMenu() {
        System.out.println("main menu");
    }
    private static void logout(Scanner scanner) {
        User.logout();
        SignupMenuView.run(scanner);
    }

    private static void play(ArrayList<String> usernames, Scanner scanner) {
        Result result = MainMenuController.play(usernames);
        System.out.println(result.getMessage());
        if (result.isValid()) {
            GameMenuView.run(scanner);
        }
    }
}
