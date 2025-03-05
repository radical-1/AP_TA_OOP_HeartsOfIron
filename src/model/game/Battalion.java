package model.game;

public class Battalion {
    private final BattalionType type;
    private final String name;
    private final Country country;
    private int level;
    private int power;
    private int captureRatio;

    public Battalion(String name, BattalionType type, Country country) {
        this.name = name;
        this.type = type;
        this.country = country;
        setInitialValues();
    }

    private void setInitialValues() {
        switch (country) {
            case GERMAN_REICH:
                switch (type) {
                    case INFANTRY:
                        power = 15;
                        captureRatio = 50;
                        break;
                    case NAVY:
                        power = 5;
                        captureRatio = 20;
                        break;
                    case PANZER:
                        power = 20;
                        captureRatio = 30;
                        break;
                    case AIRFORCE:
                        power = 10;
                        captureRatio = 40;
                        break;
                }
                break;
            case SOVIET_UNION:
                switch (type) {
                    case INFANTRY:
                        power = 20;
                        captureRatio = 20;
                        break;
                    case NAVY:
                        power = 10;
                        captureRatio = 30;
                        break;
                    case PANZER:
                        power = 15;
                        captureRatio = 60;
                        break;
                    case AIRFORCE:
                        power = 5;
                        captureRatio = 40;
                        break;
                }
                break;
            case UNITED_STATES:
                switch (type) {
                    case INFANTRY:
                        power = 5;
                        captureRatio = 30;
                        break;
                    case NAVY:
                        power = 15;
                        captureRatio = 60;
                        break;
                    case PANZER:
                        power = 10;
                        captureRatio = 40;
                        break;
                    case AIRFORCE:
                        power = 20;
                        captureRatio = 50;
                        break;
                }
                break;
            case UNITED_KINGDOM:
                switch (type) {
                    case INFANTRY:
                        power = 10;
                        captureRatio = 60;
                        break;
                    case NAVY:
                        power = 20;
                        captureRatio = 40;
                        break;
                    case PANZER:
                        power = 5;
                        captureRatio = 50;
                        break;
                    case AIRFORCE:
                        power = 15;
                        captureRatio = 20;
                        break;
                }
                break;
            case JAPAN:
                power = 10;
                switch (type) {
                    case INFANTRY:
                        captureRatio = 40;
                        break;
                    case NAVY:
                        captureRatio = 50;
                        break;
                    case PANZER:
                        captureRatio = 20;
                        break;
                    case AIRFORCE:
                        captureRatio = 30;
                        break;
                }
                break;
        }
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
