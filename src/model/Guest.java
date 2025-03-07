package model;

public class Guest extends Player {
    private final int number;

    public Guest(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "guest" + number;
    }
}
