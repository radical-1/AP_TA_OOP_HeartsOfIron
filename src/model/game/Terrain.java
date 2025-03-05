package model.game;

public enum Terrain {
    MOUNTAIN,
    FOREST,
    DESERT,
    URBAN,
    PLAIN;

    public void modify(Battalion battalion) {
        switch (this) {
            case MOUNTAIN: break;
            case FOREST: break;
            case DESERT: break;
            case URBAN: break;
            case PLAIN: break;
        }
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
