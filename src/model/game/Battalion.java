package model.game;

public class Battalion {
    private final BattalionType type;
    private final String name;
    private int level;
    private int power;
    private int captureRatio;

    public Battalion(String name, BattalionType type) {
        this.name = name;
        this.type = type;
    }

    public BattalionType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getPower() {
        return power;
    }

    public int getCaptureRatio() {
        return captureRatio;
    }

    @Override
    public String toString() {
        return name + " " + level + " " + power + " " + captureRatio;
    }
}
