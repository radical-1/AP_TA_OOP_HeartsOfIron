package model;

import java.util.ArrayList;

public enum Country {
    SOVIET_UNION(Leader.STALIN, 160000000, 300000, 100000, 50000),
    UNITED_STATES(Leader.ROOSEVELT, 120000000, 200000, 200000, 100000),
    GERMAN_REICH(Leader.HITLER, 60000000, 100000, 300000, 200000),
    UNITED_KINGDOM(Leader.CHURCHILL, 30000000, 0, 10, 1),
    JAPAN(Leader.TOKUDA, 70000000, 50000, 50000, 50000);

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
}
