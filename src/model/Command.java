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
    GO_TO_PROFILE_MENU("go to profile menu"),
    FORGET_PASSWORD("forget-password\\s+-username\\s+(?<username>\\S+)\\s+-email\\s+(?<email>\\S+)");
    final String regex;
    Command(String regex) {
        this.regex = regex;
    }
    private Matcher getMatcher(String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher  = pattern.matcher(input);
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
