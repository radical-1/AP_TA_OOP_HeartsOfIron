package model.game;

public enum Weather {
    SUNNY,
    RAINY,
    BLIZZARD,
    SANDSTORM,
    FOG;

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
