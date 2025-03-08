package model.game;

import java.util.ArrayList;

public class Faction {
    private static final ArrayList<Faction> factions;
    private final String name;
    private final ArrayList<Country> joinedCountries;

    static {
        factions = new ArrayList<>();
    }

    public Faction(String name) {
        this.name = name;
        this.joinedCountries = new ArrayList<>();
        factions.add(this);
    }

    public static ArrayList<Faction> getAllFactions() {
        return factions;
    }

    public boolean countryExists(Country country) {
        return joinedCountries.contains(country);
    }

    public void addCountry(Country country) {
        joinedCountries.add(country);
    }

    public void removeCountry(Country country) {
        joinedCountries.remove(country);
    }

    public static Faction getFactionByName(String name) {
        for (Faction faction : factions) {
            if (faction.name.equals(name)) return faction;
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
