package model.game;

import java.util.ArrayList;

public enum Country {
    SOVIET_UNION(Leader.STALIN, 160000000, 300000, 100000, 50000),
    UNITED_STATES(Leader.ROOSEVELT, 120000000, 200000, 200000, 100000),
    GERMAN_REICH(Leader.HITLER, 60000000, 100000, 300000, 200000),
    UNITED_KINGDOM(Leader.CHURCHILL, 30000000, 0, 10, 1),
    JAPAN(Leader.HIROHITO, 70000000, 50000, 50000, 50000);

    private Leader leader;
    private int stability;

    private int manpower;
    private int fuel;
    private int steel;
    private int sulfur;
    private final ArrayList<Country> puppets;

    Country(Leader leader, int manpower, int fuel, int steel, int sulfur) {
        this.leader = leader;
        this.manpower = manpower;
        this.fuel = fuel;
        this.steel = steel;
        this.sulfur = sulfur;
        this.puppets = new ArrayList<>();
        this.stability = 100;
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

    public void increaseStability() {
        stability = (int) (stability * 1.5);
    }
    public void rechargeStability() {
        stability = 100;
    }

    public void decreaseStability() {
        stability = (int) (stability * 0.5);
    }

    public void decreaseStability(double coefficient) {
        stability = (int) (stability * coefficient);
    }

    public int getManpower() {
        return manpower;
    }

    public void decreaseManpower(double manpower) {
        this.manpower = (int) (this.manpower - manpower);
    }

    public int getFuel() {
        return fuel;
    }

    public void decreaseFuel(double fuel) {
        this.fuel = (int) (this.fuel - fuel);
    }

    public void increaseFuel(double fuel) {
        this.fuel = (int) (this.fuel + fuel);
    }

    public int getSteel() {
        return steel;
    }

    public void decreaseSteel(double steel) {
        this.steel = (int) (this.steel - steel);
    }

    public void increaseSteel(double steel) {
        this.steel = (int) (this.steel - steel);
    }

    public int getSulfur() {
        return sulfur;
    }

    public void decreaseSulfur(double sulfur) {
        this.sulfur = (int) (this.sulfur - sulfur);
    }

    public void increaseSulfur(double sulfur) {
        this.sulfur = (int) (this.sulfur - sulfur);
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
                steel = (int) (steel + amount);
                break;
            case SULFUR:
                sulfur = (int) (sulfur + amount);
                break;
            case FUEL:
                fuel = (int) (fuel + amount);
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
