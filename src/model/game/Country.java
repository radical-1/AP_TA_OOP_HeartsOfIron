package model.game;

import java.util.ArrayList;

public enum Country {
    SOVIET_UNION(Leader.STALIN, 160000000, 300000, 100000, 50000),
    UNITED_STATES(Leader.ROOSEVELT, 120000000, 200000, 200000, 100000),
    GERMAN_REICH(Leader.HITLER, 60000000, 100000, 300000, 200000),
    UNITED_KINGDOM(Leader.CHURCHILL, 30000000, 0, 10, 1),
    JAPAN(Leader.TOKUDA, 70000000, 50000, 50000, 50000);

    private String name;
    private Leader leader;
    private int stability;

    private int manpower;
    private int fuel;
    private int steel;
    private int sulfur;
    private ArrayList<Country> puppets;

    Country(Leader leader, int manpower, int fuel, int steel, int sulfur) {
        this.leader = leader;
        this.manpower = manpower;
        this.fuel = fuel;
        this.steel = steel;
        this.sulfur = sulfur;
        this.puppets = new ArrayList<>();
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public int getStability() {
        return stability;
    }

    public void setStability(int stability) {
        this.stability = stability;
    }

    public int getManpower() {
        return manpower;
    }

    public void setManpower(int manpower) {
        this.manpower = manpower;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getSteel() {
        return steel;
    }

    public void setSteel(int steel) {
        this.steel = steel;
    }

    public int getSulfur() {
        return sulfur;
    }

    public void setSulfur(int sulfur) {
        this.sulfur = sulfur;
    }

    @Override
    public String toString() {
        return switch (this) {
            case SOVIET_UNION -> "Soviet Union";
            case UNITED_STATES -> "United States";
            case GERMAN_REICH -> "German Reich";
            case UNITED_KINGDOM -> "United Kingdom";
            case JAPAN -> "Japan";
        };
    }
}
