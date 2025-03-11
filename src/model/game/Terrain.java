package model.game;

public enum Terrain {
    MOUNTAIN,
    FOREST,
    DESERT,
    URBAN,
    PLAIN;

    public double getModifier(BattalionType type) {
        switch (this) {
            case MOUNTAIN:
                if (type == BattalionType.INFANTRY || type == BattalionType.PANZER)
                    return 0.5;
                break;
            case PLAIN:
                if (type == BattalionType.INFANTRY || type == BattalionType.PANZER)
                    return 1.2;
                else if (type == BattalionType.AIRFORCE)
                    return 1.25;
                break;
            case FOREST:
                if (type == BattalionType.INFANTRY || type == BattalionType.PANZER)
                    return 0.9;
                break;
            case URBAN:
                if (type == BattalionType.INFANTRY || type == BattalionType.PANZER)
                    return 1.1;
                break;
            case DESERT:
                if (type == BattalionType.AIRFORCE)
                    return 1.4;
                break;
        }
        return 1;
    }

    public static Terrain getTerrainByName(String name) {
        return switch (name) {
            case "mountain" -> MOUNTAIN;
            case "forest" -> FOREST;
            case "desert" -> DESERT;
            case "urban" -> URBAN;
            case "plain" -> PLAIN;
            default -> null;
        };
    }

    @Override
    public String toString() {
        return switch(this) {
            case MOUNTAIN -> "mountain";
            case FOREST -> "forest";
            case DESERT -> "desert";
            case URBAN -> "urban";
            case PLAIN -> "plain";
        };
    }
}
