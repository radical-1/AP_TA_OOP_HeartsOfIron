package controller;

import model.Result;
import model.game.Country;

public class GameMenuController {
    public static Result getCountryDetails(Country country) {
        String message = country.toString() + "\n";
        message += "leader : " + country.getLeader().toString() + "\n";
        message += "stability : " + country.getStability() + "\n";
        message += "man power : " + country.getManpower() + "\n";
        message += "fuel amount : " + country.getFuel() + "\n";
        message += "sulfur : " + country.getSulfur() + "\n";
        message += "steel : " + country.getSteel() + "\n";
//        message += "faction : " + country. + "\n";
        // TODO
        return null;
    }
}
