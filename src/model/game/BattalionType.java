package model.game;

public enum BattalionType {
    INFANTRY(0, 10000, 10000, 10000),
    PANZER(10000, 20000, 10000, 5000),
    AIRFORCE(50000, 35000, 10000, 1000),
    NAVY(30000, 50000, 10000, 5000);

    private final int fuel;
    private final int steel;
    private final int sulfur;
    private final int manpower;

    BattalionType(int fuel, int steel, int sulfur, int manpower) {
        this.fuel = fuel;
        this.steel = steel;
        this.sulfur = sulfur;
        this.manpower = manpower;
    }

    public int getFuel() {
        return fuel;
    }

    public int getSteel() {
        return steel;
    }

    public int getSulfur() {
        return sulfur;
    }

    public int getManpower() {
        return manpower;
    }

    public static BattalionType getBattalionTypeByName(String name) {
        return switch (name) {
            case "infantry" -> INFANTRY;
            case "panzer" -> PANZER;
            case "airforce" -> AIRFORCE;
            case "navy" -> NAVY;
            default -> null;
        };
    }
}
