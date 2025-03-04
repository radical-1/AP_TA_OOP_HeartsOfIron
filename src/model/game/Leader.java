package model.game;

public enum Leader {
    ADENAUER(Ideology.DEMOCRACY),
    PIECK(Ideology.COMMUNISM),
    HITLER(Ideology.FASCISM),
    ZOMBIE_LENIN(Ideology.DEMOCRACY),
    STALIN(Ideology.COMMUNISM),
    TROTSKY(Ideology.FASCISM),
    ROOSEVELT(Ideology.DEMOCRACY),
    BROWDER(Ideology.COMMUNISM),
    PELLEY(Ideology.FASCISM),
    CHURCHILL(Ideology.DEMOCRACY),
    MOSLEY(Ideology.FASCISM),
    HIROHITO(Ideology.FASCISM);

    private int popularity;
    private Ideology ideology;

    Leader(Ideology ideology) {
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
