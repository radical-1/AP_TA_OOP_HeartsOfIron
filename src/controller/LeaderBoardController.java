package controller;

import model.User;

import java.util.ArrayList;

public class LeaderBoardController {
    public static String getRanking() {
        StringBuilder ranking = new StringBuilder();
        ArrayList<User> users = User.getAllUsers();
        users.sort((user1, user2) -> user2.getScore() - user1.getScore());
        for (User user : users) {
            ranking.append(user.getUsername()).append(" ").append(user.getScore()).append("\n");
        }
        return ranking.toString();
    }
}
