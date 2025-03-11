package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Command {
    SHOW_CURRENT_MENU("show\\s+current\\s+menu"),
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
    SHOW_RANKING("show\\s+ranking"),
    SHOW_HISTORY("show\\s+history"),
    FORGET_PASSWORD("forget-password\\s+-username\\s+(?<username>\\S+)\\s+-email\\s+(?<email>\\S+)"),
    SHOW_COUNTRY_DETAIL("show\\s+detail\\s+(?<countryName>.+)"),
    TILE_OWNER("tile\\s+owner\\s+(?<index>-?\\d+)"),
    TILE_LAND_NEIGHBORS("tile\\s+neighbors\\s+(?<index>-?\\d+)"),
    TILE_SEA_NEIGHBORS("tile\\s+sea\\s+neighbors\\s+(?<index>-?\\d+)"),
    TILE_WEATHER("show\\s+weather\\s+(?<index>-?\\d+)"),
    TILE_TERRAIN("show\\s+terrain\\s+(?<index>-?\\d+)"),
    SHOW_BATTALIONS("show\\s+battalions\\s+(?<index>-?\\d+)"),
    SHOW_FACTORIES("show\\s+factories\\s+(?<index>-?\\d+)"),
    SET_TERRAIN("set\\s+terrain\\s+(?<index>-?\\d+)\\s+(?<name>\\S+)"),
    SET_WEATHER("set\\s+weather\\s+(?<index>-?\\d+)\\s+(?<name>\\S+)"),
    CREATE_FACTION("create\\s+faction\\s+(?<name>\\S+)"),
    JOIN_FACTION("join\\s+faction\\s+(?<name>\\S+)"),
    LEAVE_FACTION("leave\\s+faction\\s+(?<name>\\S+)"),
    BUILD_FACTORY("build\\s+factory\\s+(?<index>-?\\d+)\\s+(?<type>\\S+)\\s+(?<name>\\S+)"),
    RUN_FACTORY("run\\s+factory\\s+(?<index>-?\\d+)\\s+(?<name>\\S+)\\s+(?<manpower_count>-?\\d+)"),
    PUPPET("puppet\\s+(?<countryName>.+?)"),
    PLAY("play(?:\\s+(\\S+)){1,4}"),
    CHOOSE_COUNTRY("choose\\s+country(?:\\s+(\\.+)){5}"),
    SWITCH_PLAYER("switch\\s+player\\s+(?<username>\\S+)"),
    ADD_BATTALION("add\\s+battalion\\s+(?<index>-?\\d+)\\s+(?<type>\\S+)\\s+(?<name>\\S+)"),
    MOVE_BATTALION("move\\s+battalion\\s+(?<source_index>\\S+)\\s+(?<name>\\S+)\\s+(?<dest_index>\\S+)"),
    UPGRADE_BATTALION("upgrade\\s+battalion\\s+(?<index>-?\\d+)\\s+(?<name>\\S+)"),
    ATTACK("attack\\s+<source_index>\\s+<dest_index>\\s+<battalion_type>");

    private final String regex;
    Command(String regex) {
        this.regex = regex;
    }
    public Matcher getMatcher(String input) {
        Matcher matcher  = Pattern.compile(regex).matcher(input);
        matcher.matches();
        return matcher;
    }
    public boolean matches(String input) {
        return getMatcher(input).matches();
    }
    public String getGroup(String input, String group) {
        return getMatcher(input).group(group);
    }
}
