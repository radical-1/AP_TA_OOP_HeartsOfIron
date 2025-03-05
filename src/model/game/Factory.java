package model.game;

public class Factory {
    private final FactoryType type;
    private final String name;
    private int manpower;

    public Factory(FactoryType type, String name, int manpower) {
        this.type = type;
        this.name = name;
        this.manpower = manpower;
    }

    public FactoryType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getManpower() {
        return manpower;
    }
}
