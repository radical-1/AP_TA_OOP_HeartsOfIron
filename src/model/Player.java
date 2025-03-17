package model;

import model.game.Country;

public class Player {
    protected int score;
    protected Country country;
    protected String username;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(double amount) {
        this.score = (int) (this.score + amount);
    }

    public void decreaseScore(double amount) {
        this.score = (int) (this.score - amount);
    }

    public String getUsername() {
        return username;
    }
}
