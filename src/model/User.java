package model;

import java.util.ArrayList;

public class User {
    public static User currentUser;
    public static ArrayList<User> allUsers = new ArrayList<>();
    private final String username;
    private final String password;
    private final String email;
    private int score;
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        score = 0;
        allUsers.add(this);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int addedScore) {
        this.score = score + addedScore;
    }

    public static User getUserByUsername(String username) {
        for(User user : allUsers) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }


}
