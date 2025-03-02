package model;

import java.util.ArrayList;
import java.util.Arrays;

public enum Tile {
    TILE1(1, Country.SOVIET_UNION),
    TILE2(2, Country.SOVIET_UNION),
    TILE3(3, Country.SOVIET_UNION),
    TILE4(4, Country.SOVIET_UNION),
    TILE5(5, Country.SOVIET_UNION),
    TILE6(6, Country.SOVIET_UNION),
    TILE7(7, Country.SOVIET_UNION),
    TILE8(8, Country.SOVIET_UNION),
    TILE9(9, Country.SOVIET_UNION),
    TILE10(10, Country.SOVIET_UNION),
    TILE11(11, Country.SOVIET_UNION),
    TILE12(12, Country.SOVIET_UNION),
    TILE13(13, Country.SOVIET_UNION),
    TILE14(14, Country.SOVIET_UNION),
    TILE15(15, Country.SOVIET_UNION),
    TILE16(16, Country.SOVIET_UNION),
    TILE17(17, Country.UNITED_STATES),
    TILE18(18, Country.UNITED_STATES),
    TILE19(19, Country.UNITED_STATES),
    TILE20(20, Country.UNITED_STATES),
    TILE21(21, Country.UNITED_STATES),
    TILE22(22, Country.UNITED_STATES),
    TILE23(23, Country.UNITED_STATES),
    TILE24(24, Country.UNITED_STATES),
    TILE25(25, Country.UNITED_STATES),
    TILE26(26, Country.UNITED_STATES),
    TILE27(27, Country.UNITED_STATES),
    TILE28(28, Country.UNITED_STATES),
    TILE29(29, Country.UNITED_STATES),
    TILE30(30, Country.UNITED_STATES),
    TILE31(31, Country.UNITED_STATES),
    TILE32(32, Country.UNITED_STATES),
    TILE33(33, Country.UNITED_STATES),
    TILE34(34, Country.UNITED_STATES),
    TILE35(35, Country.GERMAN_REICH),
    TILE36(36, Country.GERMAN_REICH),
    TILE37(37, Country.GERMAN_REICH),
    TILE38(38, Country.GERMAN_REICH),
    TILE39(39, Country.GERMAN_REICH),
    TILE40(40, Country.GERMAN_REICH),
    TILE41(41, Country.GERMAN_REICH),
    TILE42(42, Country.GERMAN_REICH),
    TILE43(43, Country.GERMAN_REICH),
    TILE44(44, Country.GERMAN_REICH),
    TILE45(45, Country.GERMAN_REICH),
    TILE46(46, Country.GERMAN_REICH),
    TILE47(47, Country.GERMAN_REICH),
    TILE48(48, Country.GERMAN_REICH),
    TILE49(49, Country.GERMAN_REICH),
    TILE50(50, Country.GERMAN_REICH),
    TILE51(51, Country.JAPAN),
    TILE52(52, Country.JAPAN),
    TILE53(53, Country.JAPAN),
    TILE54(54, Country.UNITED_KINGDOM),
    TILE55(55, Country.UNITED_KINGDOM),
    TILE56(56, Country.UNITED_KINGDOM);

    private final int index;
    private Country owner;
    private final ArrayList<Factory> factories;
    private final ArrayList<Tile> landNeighbors;
    private final ArrayList<Tile> maritimeNeighbors;
    private Terrain terrain;
    private Weather weather;

    private final ArrayList<Battalion> battalions;

    Tile(int index, Country owner) {
        this.index = index;
        this.owner = owner;
        this.terrain = Terrain.PLAIN;
        this.weather = Weather.SUNNY;
        this.landNeighbors = new ArrayList<>();
        this.maritimeNeighbors = new ArrayList<>();
        this.factories = new ArrayList<>();
        this.battalions = new ArrayList<>();
    }

    static {
        TILE1.landNeighbors.addAll(Arrays.asList(TILE2, TILE5));
        TILE2.landNeighbors.addAll(Arrays.asList(TILE1, TILE3, TILE6));
        TILE3.landNeighbors.addAll(Arrays.asList(TILE2, TILE4, TILE7));
        TILE4.landNeighbors.addAll(Arrays.asList(TILE3, TILE8));
        TILE5.landNeighbors.addAll(Arrays.asList(TILE1, TILE6, TILE9));
        TILE6.landNeighbors.addAll(Arrays.asList(TILE2, TILE5, TILE7, TILE10));
        TILE7.landNeighbors.addAll(Arrays.asList(TILE3, TILE6, TILE8, TILE11));
        TILE8.landNeighbors.addAll(Arrays.asList(TILE4, TILE7, TILE12));
        TILE9.landNeighbors.addAll(Arrays.asList(TILE5, TILE10, TILE13));
        TILE10.landNeighbors.addAll(Arrays.asList(TILE6, TILE9, TILE11, TILE14));
        TILE11.landNeighbors.addAll(Arrays.asList(TILE7, TILE10, TILE12, TILE15));
        TILE12.landNeighbors.addAll(Arrays.asList(TILE8, TILE11, TILE16));
        TILE13.landNeighbors.addAll(Arrays.asList(TILE9, TILE14));
        TILE14.landNeighbors.addAll(Arrays.asList(TILE10, TILE13, TILE15));
        TILE15.landNeighbors.addAll(Arrays.asList(TILE11, TILE14, TILE16));
        TILE16.landNeighbors.addAll(Arrays.asList(TILE12, TILE15, TILE21, TILE22, TILE39));
        TILE17.landNeighbors.addAll(Arrays.asList(TILE14, TILE18, TILE23));
        TILE18.landNeighbors.addAll(Arrays.asList(TILE14, TILE17, TILE19, TILE24));
        TILE19.landNeighbors.addAll(Arrays.asList(TILE15, TILE18, TILE20, TILE25));
        TILE20.landNeighbors.addAll(Arrays.asList(TILE15, TILE19, TILE21, TILE26));
        TILE21.landNeighbors.addAll(Arrays.asList(TILE16, TILE20, TILE22, TILE27));
        TILE22.landNeighbors.addAll(Arrays.asList(TILE16, TILE21, TILE28, TILE43));
        TILE23.landNeighbors.addAll(Arrays.asList(TILE17, TILE24, TILE29));
        TILE24.landNeighbors.addAll(Arrays.asList(TILE18, TILE23, TILE25, TILE30));
        TILE25.landNeighbors.addAll(Arrays.asList(TILE19, TILE24, TILE26, TILE31));
        TILE26.landNeighbors.addAll(Arrays.asList(TILE20, TILE25, TILE27, TILE32));
        TILE27.landNeighbors.addAll(Arrays.asList(TILE21, TILE26, TILE28, TILE33));
        TILE28.landNeighbors.addAll(Arrays.asList(TILE22, TILE27, TILE34, TILE47));
        TILE29.landNeighbors.addAll(Arrays.asList(TILE23, TILE30));
        TILE30.landNeighbors.addAll(Arrays.asList(TILE24, TILE29, TILE31));
        TILE31.landNeighbors.addAll(Arrays.asList(TILE25, TILE30, TILE32));
        TILE32.landNeighbors.addAll(Arrays.asList(TILE26, TILE31, TILE33));
        TILE33.landNeighbors.addAll(Arrays.asList(TILE27, TILE32, TILE34));
        TILE34.landNeighbors.addAll(Arrays.asList(TILE28, TILE33));
        TILE35.landNeighbors.addAll(Arrays.asList(TILE25, TILE36, TILE39));
        TILE36.landNeighbors.addAll(Arrays.asList(TILE35, TILE37, TILE40));
        TILE37.landNeighbors.addAll(Arrays.asList(TILE54, TILE36, TILE38, TILE41));
        TILE38.landNeighbors.addAll(Arrays.asList(TILE37, TILE42, TILE55));
        TILE39.landNeighbors.addAll(Arrays.asList(TILE16, TILE35, TILE40, TILE43));
        TILE40.landNeighbors.addAll(Arrays.asList(TILE36, TILE39, TILE41, TILE44));
        TILE41.landNeighbors.addAll(Arrays.asList(TILE37, TILE40, TILE42, TILE45));
        TILE42.landNeighbors.addAll(Arrays.asList(TILE38, TILE41, TILE46));
        TILE43.landNeighbors.addAll(Arrays.asList(TILE22, TILE39, TILE44, TILE47));
        TILE44.landNeighbors.addAll(Arrays.asList(TILE40, TILE43, TILE45, TILE48));
        TILE45.landNeighbors.addAll(Arrays.asList(TILE41, TILE44, TILE46, TILE49));
        TILE46.landNeighbors.addAll(Arrays.asList(TILE42, TILE45, TILE50));
        TILE47.landNeighbors.addAll(Arrays.asList(TILE28, TILE43, TILE48));
        TILE48.landNeighbors.addAll(Arrays.asList(TILE44, TILE47, TILE49));
        TILE49.landNeighbors.addAll(Arrays.asList(TILE45, TILE48, TILE50));
        TILE50.landNeighbors.addAll(Arrays.asList(TILE46, TILE49, TILE51, TILE52));
        TILE51.landNeighbors.addAll(Arrays.asList(TILE50, TILE53));
        TILE52.landNeighbors.addAll(Arrays.asList(TILE50, TILE53));
        TILE53.landNeighbors.addAll(Arrays.asList(TILE51, TILE52));
        TILE54.landNeighbors.addAll(Arrays.asList(TILE37, TILE55));
        TILE55.landNeighbors.addAll(Arrays.asList(TILE38, TILE54, TILE56));
        TILE56.landNeighbors.add(TILE55);
        TILE8.maritimeNeighbors.addAll(Arrays.asList(TILE35, TILE36, TILE54));
        TILE35.maritimeNeighbors.addAll(Arrays.asList(TILE8, TILE36, TILE54));
        TILE36.maritimeNeighbors.addAll(Arrays.asList(TILE8, TILE35, TILE54));
        TILE54.maritimeNeighbors.addAll(Arrays.asList(TILE8, TILE35, TILE36));
        TILE34.maritimeNeighbors.addAll(Arrays.asList(TILE47, TILE48, TILE49, TILE52));
        TILE47.maritimeNeighbors.addAll(Arrays.asList(TILE34, TILE48, TILE49, TILE52));
        TILE48.maritimeNeighbors.addAll(Arrays.asList(TILE34, TILE47, TILE49, TILE52));
        TILE49.maritimeNeighbors.addAll(Arrays.asList(TILE34, TILE47, TILE48, TILE52));
        TILE52.maritimeNeighbors.addAll(Arrays.asList(TILE34, TILE47, TILE48, TILE49));
    }

    public int getIndex() {
        return index;
    }

    public Country getOwner() {
        return owner;
    }

    public void setOwner(Country owner) {
        this.owner = owner;
    }

    public ArrayList<Factory> getFactories() {
        return factories;
    }

    public void addFactory(Factory factory) {
        factories.add(factory);
    }

    public ArrayList<Tile> getLandNeighbors() {
        return landNeighbors;
    }

    public ArrayList<Tile> getMaritimeNeighbors() {
        return maritimeNeighbors;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public void addBattalion(Battalion battalion) {
        battalions.add(battalion);
    }
}
