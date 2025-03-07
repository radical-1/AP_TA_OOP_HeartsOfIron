package model;

import java.util.ArrayList;

public class Game {
    private static final ArrayList<Game> games;

    public static Game currentGame;

    private final ArrayList<Player> players;

    static {
        games = new ArrayList<>();
    }

    public Game(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
