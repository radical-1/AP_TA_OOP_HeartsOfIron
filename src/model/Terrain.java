package model;

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
}
