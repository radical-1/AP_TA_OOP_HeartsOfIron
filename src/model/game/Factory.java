package model.game;

public class Factory {
    private final FactoryType type;
    private final String name;
    private int manpower;

    private int extracted;

    public Factory(FactoryType type, String name) {
        this.type = type;
        this.name = name;
        extracted = 0;
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

    @Override
    public String toString() {
        return name + " " + (type.getMaxPower() - extracted);
    }
}
