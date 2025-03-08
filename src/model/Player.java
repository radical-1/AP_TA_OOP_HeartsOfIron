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

    public void updateScore(int addedScore) {
        this.score = score + addedScore;
    }

    public String getUsername() {
        return username;
    }
}
