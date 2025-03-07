package model;

public class Guest extends Player {
    private final int number;

    public Guest(int number) {
        this.number = number;
    }

    public String getUsername() {
        return "guest" + number;
    }
}
