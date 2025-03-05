package model.game;

public enum Weather {
    SUNNY,
    RAINY,
    BLIZZARD,
    SANDSTORM,
    FOG;

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
