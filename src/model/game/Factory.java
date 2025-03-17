package model.game;

public class Factory {
    private final FactoryType type;
    private final String name;
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

    public int getRemainingResource() {
        return type.getMaxPower() - extracted;
    }

    public void useResource(double amount) {
        extracted = (int) (extracted + amount);
    }

    @Override
    public String toString() {
        return name + " " + (type.getMaxPower() - extracted);
    }
}
