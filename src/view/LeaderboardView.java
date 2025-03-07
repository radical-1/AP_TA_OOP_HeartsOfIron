package view;

import controller.LeaderBoardController;
import model.Command;

import java.util.Scanner;

public class LeaderboardView implements Menu {
    public static void run(Scanner scanner) {
        String input;
        while(true) {
            input = scanner.nextLine().trim();
            if (Command.EXIT.matches(input)) {
                Menu.exit();
                break;
            }
            else if (Command.BACK.matches(input)) {
                MainMenuView.run(scanner);
            }
            else if(Command.SHOW_CURRENT_MENU.matches(input)) {
                showCurrentMenu();
            }
            else if(Command.SHOW_RANKING.matches(input)) {
                showRanking();
            } else if(Command.SHOW_HISTORY.matches(input)) {
                showHistory();
            } else {
                Menu.invalidCommand();
            }
        }
    }

    public static void showCurrentMenu() {
        System.out.println("leaderboard menu");
    }

    public static void showRanking() {
        System.out.println("Leaderboard:");
        System.out.println(LeaderBoardController.getRanking());
    }

    public static  void showHistory() {
        System.out.println("History:");
        // TODO : implement this
    }
}
