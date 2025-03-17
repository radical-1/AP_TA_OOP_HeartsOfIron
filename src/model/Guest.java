package model;

import java.util.ArrayList;

public class Guest extends Player {
    private static final ArrayList<Guest> allGuests;

    static {
        allGuests = new ArrayList<>();
    }

    public Guest(int number) {
        this.username = "guest" + number;
        allGuests.add(this);
    }

    public static Guest getGuestByUsername(String username) {
        for (Guest guest: allGuests)
            if (guest.username.equals(username)) return guest;
        return null;
    }
}
