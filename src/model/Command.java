package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Command {
    SHOW_CURRENT_MENU("show current menu"),
    BACK("back"),
    EXIT("exit"),
    LOGOUT("logout"),
    WITHOUT_WHITESPACE("\\S+"),
    REGISTER_USER("register\\s+-username\\s+(?<username>\\S+)\\s+-password\\s+(?<password>.+)\\s+-email\\s+(?<email>\\S+)"),
    VALID_USERNAME("[a-zA-Z_]+"),
    PASSWORD_LENGTH(".{8,20}"),
    PASSWORD_SPECIAL_CHARACTERS("(?=\\S*[@#$^&!])\\S*"),
    PASSWORD_STARTS_WITH_LETTER("(?=^[a-zA-Z])\\S+"),
    EMAIL_VALID_ADDRESS("[a-zA-Z0-9]+(\\.[a-zA-Z0-9]*)?@[a-z]+\\.com"),
    LOGIN_USER("login\\s+username\\s+(?<username>\\S+)\\s+password\\s+(?<password>\\S+)"),
    GO_TO_LOGIN_MENU("login"),
    GO_TO_LEADERBOARD("leaderboard"),
    SHOW_RANKING("show ranking"),
    SHOW_HISTORY("show history"),
    FORGET_PASSWORD("forget-password\\s+-username\\s+(?<username>\\S+)\\s+-email\\s+(?<email>\\S+)"),
    SHOW_COUNTRY_DETAIL("show detail (?<countryName>\\S+)"),
    TILE_OWNER("tile owner (?<index>-?\\d+)"),
    TILE_LAND_NEIGHBORS("tile neighbors (?<index>-?\\d+)"),
    TILE_SEA_NEIGHBORS("tile sea neighbors (?<index>-?\\d+)"),
    TILE_WEATHER("show weather (?<index>-?\\d+)"),
    TILE_TERRAIN("show terrain (?<index>-?\\d+)"),
    SHOW_BATTALIONS("show battalions (?<index>-?\\d+)"),
    SHOW_FACTORIES("show factories (?<index>-?\\d+)"),
    SET_TERRAIN("set terrain (?<index>-?\\d+) (?<name>\\S+)"),
    SET_WEATHER("set weather (?<index>-?\\d+) (?<name>\\S+)"),
    CREATE_FACTION("create faction (?<name>\\S+)"),
    JOIN_FACTION("join faction (?<name>\\S+)"),
    LEAVE_FACTION("leave faction (?<name>\\S+)"),
    BUILD_FACTORY("build factory (?<index>-?\\d+) (?<type>\\S+) (?<name>\\S+)");

    private final String regex;
    Command(String regex) {
        this.regex = regex;
    }
    private Matcher getMatcher(String input) {
        Matcher matcher  = Pattern.compile(regex).matcher(input);
        if (matcher.matches()) return matcher;
        return null;
    }
    public boolean matches(String input) {
        return getMatcher(input).matches();
    }
    public String getGroup(String input, String group) {
        return getMatcher(input).group(group);
    }
}
