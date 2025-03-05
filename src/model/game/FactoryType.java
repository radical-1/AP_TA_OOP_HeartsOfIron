package model.game;

public enum FactoryType {
    STEEL(10000, 0, 10, 30000),
    SULFUR(20000, 0, 20, 20000),
    FUEL(50000, 5000, 50, 100000);

    private final int manpowerCost;
    private final int steelCost;
    private final int productionPerManpower;
    private final int maxPower;

    FactoryType(int manpowerCost, int steelCost, int productionPerManpower, int maxPower) {
        this.manpowerCost = manpowerCost;
        this.steelCost = steelCost;
        this.productionPerManpower = productionPerManpower;
        this.maxPower = maxPower;
    }

    public int getManpowerCost() {
        return manpowerCost;
    }

    public int getSteelCost() {
        return steelCost;
    }

    public int getProductionPerManpower() {
        return productionPerManpower;
    }

    public int getMaxPower() {
        return maxPower;
    }

    @Override
    public String toString() {
        return ""; //TODO
    }
}
