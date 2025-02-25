package controller;

import model.Result;
import model.User;

public class LoginMenuController {
    public static Result login(String username, String password) {
        User user = User.getUserByUsername(username);
        if(user == null) {
            return new Result(false, "username doesn't exist");
        }
        if(!user.getPassword().equals(password)) {
            return new Result(false, "password is incorrect!");
        }
        return new Result(true, "user logged in successfully");
    }
    public static Result forgetPassword(String username, String email) {
        User user = User.getUserByUsername(username);
        if(user == null) {
            return new Result(false, "username doesn't exist");
        }
        if(!user.getEmail().equals(email)) {
            return new Result(false, "email doesn't match!");
        }
        String result = "password: " + user.getPassword();
        return new Result(true, result);

    }


}
