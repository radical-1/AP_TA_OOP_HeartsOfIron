package model.game;

import java.util.ArrayList;

public enum Country {
    SOVIET_UNION(Leader.STALIN, 160000000, 300000, 100000, 50000),
    UNITED_STATES(Leader.ROOSEVELT, 120000000, 200000, 200000, 100000),
    GERMAN_REICH(Leader.HITLER, 60000000, 100000, 300000, 200000),
    UNITED_KINGDOM(Leader.CHURCHILL, 30000000, 0, 10, 1),
    JAPAN(Leader.HIROHITO, 70000000, 50000, 50000, 50000);

    private Leader leader;
    private double stability;

    private double manpower;
    private double fuel;
    private double steel;
    private double sulfur;
    private final ArrayList<Country> puppets;

    Country(Leader leader, double manpower, double fuel, double steel, int sulfur) {
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

    public double getStability() {
        return stability;
    }

    public void increaseStability() {
        stability *= 1.5;
    }
    public void rechargeStability() {
        stability = 100;
    }

    public void decreaseStability() {
        stability *= 0.5;
    }

    public void decreaseStability(double coefficient) {
        stability *= coefficient;
    }

    public double getManpower() {
        return manpower;
    }

    public void decreaseManpower(double manpower) {
        this.manpower -= manpower;
    }

    public double getFuel() {
        return fuel;
    }

    public void decreaseFuel(double fuel) {
        this.fuel -= fuel;
    }

    public void increaseFuel(double fuel) {
        this.fuel += fuel;
    }

    public double getSteel() {
        return steel;
    }

    public void decreaseSteel(double steel) {
        this.steel -= steel;
    }

    public void increaseSteel(double steel) {
        this.steel += steel;
    }

    public double getSulfur() {
        return sulfur;
    }

    public void decreaseSulfur(double sulfur) {
        this.sulfur -= sulfur;
    }

    public void increaseSulfur(double sulfur) {
        this.sulfur += sulfur;
    }

    public ArrayList<Country> getPuppets() {
        return puppets;
    }

    public void addPuppet(Country puppet) {
        this.puppets.add(puppet);
    }

    public boolean isPuppet(Country country) {
        return puppets.contains(country);
    }

    public void addResource(FactoryType type, double amount) {
        switch (type) {
            case STEEL:
                steel += amount;
                break;
            case SULFUR:
                sulfur += amount;
                break;
            case FUEL:
                fuel += amount;
                break;
        }
    }

    public static Country getCountryByName(String name) {
        return switch (name) {
            case "Soviet Union" -> SOVIET_UNION;
            case "United States" -> UNITED_STATES;
            case "German Reich" -> GERMAN_REICH;
            case "United Kingdom" -> UNITED_KINGDOM;
            case "Japan" -> JAPAN;
            default -> null;
        };
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
