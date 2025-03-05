package model.game;

public class Factory {
    private final FactoryType type;
    private final String name;
    private int manpower;

    public Factory(FactoryType type, String name) {
        this.type = type;
        this.name = name;
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
        return ""; //TODO
    }
}
