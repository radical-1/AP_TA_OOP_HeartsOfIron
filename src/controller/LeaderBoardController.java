package controller;

import model.Game;
import model.User;

import java.util.ArrayList;

public class LeaderBoardController {
    public static String getRanking() {
        StringBuilder ranking = new StringBuilder();
        ArrayList<User> users = User.getAllUsers();
        users.sort((user1, user2) -> {
            int scoreComparison = Double.compare(user2.getScore(), user1.getScore());
            if (scoreComparison == 0)
                return user1.getUsername().compareTo(user2.getUsername());
            return scoreComparison;
        });
        for (User user : users) {
            ranking.append("\n");
            ranking.append(user.getUsername()).append(" ").append(user.getScore());
        }
        return ranking.toString().trim();
    }

    public static String getHistory() {
        StringBuilder history = new StringBuilder();
        ArrayList<Game> games = Game.getAllGames();
        int start = 0;
        int finish = games.size() - 1;
        if (games.size() >= 5) start = games.size() - 5;
        for (int i = start; i <= finish; i++) {
            history.append("\n");
            history.append(games.get(i).toString());
            if (i < finish) history.append("\n----");
        }
        return history.toString().trim();
    }
}
