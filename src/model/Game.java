package model;

import java.util.ArrayList;

public record Game(ArrayList<Player> players) {
    private static final ArrayList<Game> games;

    public static Game currentGame;
    public static Player currentPlayer;

    static {
        games = new ArrayList<>();
    }

    public Game(ArrayList<Player> players) {
        this.players = players;
        games.add(this);
    }

    public static ArrayList<Game> getAllGames() {
        return games;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            string
                    .append(players.get(i).getUsername()).append(" ")
                    .append(players.get(i).getCountry().toString()).append(" ")
                    .append(players.get(i).getScore());
            if (i < 4) string.append("\n");
        }
        return string.toString();
    }
}
