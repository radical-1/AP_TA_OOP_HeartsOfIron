package model.game;

public enum Leader {
    ADENAUER(Country.GERMAN_REICH, Ideology.DEMOCRACY),
    PIECK(Country.GERMAN_REICH, Ideology.COMMUNISM),
    HITLER(Country.GERMAN_REICH, Ideology.FASCISM),
    ZOMBIE_LENIN(Country.SOVIET_UNION, Ideology.DEMOCRACY),
    STALIN(Country.SOVIET_UNION, Ideology.COMMUNISM),
    TROTSKY(Country.SOVIET_UNION, Ideology.FASCISM),
    ROOSEVELT(Country.UNITED_STATES, Ideology.DEMOCRACY),
    BROWDER(Country.UNITED_STATES, Ideology.COMMUNISM),
    PELLEY(Country.UNITED_STATES, Ideology.FASCISM),
    CHURCHILL(Country.UNITED_KINGDOM, Ideology.DEMOCRACY),
    MOSLEY(Country.UNITED_KINGDOM, Ideology.FASCISM),
    HIROHITO(Country.JAPAN, Ideology.FASCISM);

    private final Country country;
    private int popularity;
    private Ideology ideology;

    Leader(Country country, Ideology ideology) {
        this.country = country;
        this.popularity = 100;
        this.ideology = ideology;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public Ideology getIdeology() {
        return ideology;
    }

    public void setIdeology(Ideology ideology) {
        this.ideology = ideology;
    }

    public Country getCountry() {
        return country;
    }

    public static Leader getLeaderByName(String name) {
        return switch (name) {
            case "adenauer" -> ADENAUER;
            case "pieck" -> PIECK;
            case "hitler" -> HITLER;
            case "zombie lenin" -> ZOMBIE_LENIN;
            case "stalin" -> STALIN;
            case "trotsky" -> TROTSKY;
            case "roosevelt" -> ROOSEVELT;
            case "browder" -> BROWDER;
            case "pelley" -> PELLEY;
            case "churchill" -> CHURCHILL;
            case "mosley" -> MOSLEY;
            case "hirohito" -> HIROHITO;
            default -> null;
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case ADENAUER -> "adenauer";
            case PIECK -> "pieck";
            case HITLER -> "hitler";
            case ZOMBIE_LENIN -> "zombie lenin";
            case STALIN -> "stalin";
            case TROTSKY -> "trotsky";
            case ROOSEVELT -> "roosevelt";
            case BROWDER -> "browder";
            case PELLEY -> "pelley";
            case CHURCHILL -> "churchill";
            case MOSLEY -> "mosley";
            case HIROHITO -> "hirohito";
        };
    }
}
