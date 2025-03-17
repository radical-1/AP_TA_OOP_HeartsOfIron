package controller;

import model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainMenuController {
    public static Result play(ArrayList<String> usernames) {
        ArrayList<Player> players = new ArrayList<>();
        players.add(User.currentUser);
        User user;
        for (String username: usernames) {
            user = User.getUserByUsername(username);
            if (user == null)
                return new Result(false, "select between available users");
            if (Collections.frequency(usernames, username) > 1)
                return new Result(false, "users must be distinct");
            players.add(user);
        }

        if (Collections.frequency(players, User.currentUser) > 1)
                return new Result(false, "you can't choose urself");

        int size = players.size();
        for (int i = 1; i <= 5 - size; i++) players.add(new Guest(i));
        Game.currentGame = new Game(players);
        Game.currentPlayer = User.currentUser;

        return new Result(true, "aghaaz faAliat");
    }
}
