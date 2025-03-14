package controller;

import model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainMenuController {
    public static Result play(ArrayList<String> usernames) {
        ArrayList<Player> players = new ArrayList<>();
        User user;
        for (String username: usernames) {
            user = User.getUserByUsername(username);
            if (user == null)
                return new Result(false, "select between available users");
            if (Collections.frequency(usernames, username) > 1)
                return new Result(false, "users must be distinct");
            players.add(user);
        }

        for (Player player: players) {
            if (player == User.currentUser)
                return new Result(false, "you can't choose urself");
        }

        for (int i = 1; i <= 5 - players.size(); i++) players.add(new Guest(i));

        Game.currentGame = new Game(players);

        return new Result(true, "aghaaz faAliat");
    }
}
