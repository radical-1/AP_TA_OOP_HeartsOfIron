package model.game;

public enum Weather {
    SUNNY,
    RAINY,
    BLIZZARD,
    SANDSTORM,
    FOG;

    public double getModifier(BattalionType type) {
            switch (this) {
                case RAINY:
                    if (type == BattalionType.INFANTRY || type == BattalionType.PANZER)
                        return 0.8;
                    else if (type == BattalionType.AIRFORCE)
                        return 0.1;
                    break;
                case BLIZZARD:
                    if (type == BattalionType.INFANTRY || type == BattalionType.PANZER)
                        return 0.6;
                    else if (type == BattalionType.AIRFORCE)
                        return 0.3;
                    break;
                case SANDSTORM:
                    if (type == BattalionType.INFANTRY || type == BattalionType.PANZER)
                        return 0.3;
                    else if (type == BattalionType.AIRFORCE)
                        return 0.6;
                    break;
                case FOG:
                    if (type == BattalionType.INFANTRY || type == BattalionType.PANZER)
                        return 0.2;
                    else if (type == BattalionType.AIRFORCE)
                        return 0.7;
                    break;
            }
            return 1;
    }

    public static Weather getWeatherByName(String name) {
        return switch (name) {
            case "sunny" -> SUNNY;
            case "rainy" -> RAINY;
            case "blizzard" -> BLIZZARD;
            case "sandstorm" -> SANDSTORM;
            case "fog" -> FOG;
            default -> null;
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case SUNNY -> "sunny";
            case RAINY -> "rainy";
            case BLIZZARD -> "blizzard";
            case SANDSTORM -> "sandstorm";
            case FOG -> "fog";
        };
    }
}
