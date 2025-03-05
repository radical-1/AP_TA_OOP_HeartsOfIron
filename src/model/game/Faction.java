package model.game;

import java.util.ArrayList;

public record Faction(String name) {
    private static final ArrayList<Faction> factions;

    static {
        factions = new ArrayList<>();
    }

    public Faction(String name) {
        this.name = name;
        factions.add(this);
    }

    public static Faction getFactionByName(String name) {
        for (Faction faction : factions) {
            if (faction.name.equals(name)) return faction;
        }
        return null;
    }
}
