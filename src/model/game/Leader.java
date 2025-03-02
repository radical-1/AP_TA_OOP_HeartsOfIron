package model.game;

public enum Leader {
    ADENAUER(Ideology.DEMOCRACY),
    HITLER(Ideology.FASCISM),
    PUTIN(Ideology.DEMOCRACY),
    STALIN(Ideology.COMMUNISM),
    RODZAEVSKY(Ideology.FASCISM),
    ROOSEVELT(Ideology.DEMOCRACY),
    BROWDER(Ideology.COMMUNISM),
    CHURCHILL(Ideology.DEMOCRACY),
    EVIL_CHURCHILL(Ideology.COMMUNISM),
    KATAYAMA(Ideology.DEMOCRACY),
    TOKUDA(Ideology.COMMUNISM),
    HIROHITO(Ideology.FASCISM);

    private int popularity;
    private Ideology ideology;

    Leader(Ideology ideology) {
        this.popularity = 100;
        this.ideology = ideology;
    }
}
