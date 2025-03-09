package model.game;

public enum Terrain {
    MOUNTAIN,
    FOREST,
    DESERT,
    URBAN,
    PLAIN;

    public static void modify(Tile tile) {
        for (Battalion battalion : tile.getBattalions()) {
            BattalionType type = battalion.getType();

            switch (tile.getTerrain()) {
                case MOUNTAIN:
                    if (type == BattalionType.INFANTRY || type == BattalionType.PANZER)
                        battalion.multiplyPower(0.5);
                    break;
                case PLAIN:
                    if (type == BattalionType.INFANTRY || type == BattalionType.PANZER)
                        battalion.multiplyPower(1.2);
                    else if (type == BattalionType.AIRFORCE)
                        battalion.multiplyPower(1.25);
                    break;
                case FOREST:
                    if (type == BattalionType.INFANTRY || type == BattalionType.PANZER)
                        battalion.multiplyPower(0.9);
                    break;
                case URBAN:
                    if (type == BattalionType.INFANTRY || type == BattalionType.PANZER)
                        battalion.multiplyPower(1.1);
                    break;
                case DESERT:
                    if (type == BattalionType.AIRFORCE)
                        battalion.multiplyPower(1.4);
                    break;
            }
        }
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
