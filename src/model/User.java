package model;

import model.game.Country;

import java.util.ArrayList;

public class User extends Player {
    public static User currentUser;
    public static ArrayList<User> allUsers = new ArrayList<>();
    private final String username;
    private final String password;
    private final String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        score = 0;
        allUsers.add(this);
        country = null;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return email;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public static User getUserByUsername(String username) {
        for(User user : allUsers) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    public static void logout() {
        currentUser = null;
    }
}
