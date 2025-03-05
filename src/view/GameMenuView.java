package view;

import controller.GameMenuController;
import model.Command;
import model.Result;

import java.util.Scanner;

public class GameMenuView implements Menu {
    public static void run(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (Command.EXIT.matches(input)) {
                Menu.exit();
                break;
            }
            else if (Command.SHOW_COUNTRY_DETAIL.matches(input)) {
                String countryName = Command.SHOW_COUNTRY_DETAIL.getGroup(input, "countryName");
                getCountryDetails(countryName);
            }
            else if (Command.TILE_OWNER.matches(input)) {
                String indexString = Command.TILE_OWNER.getGroup(input, "index");
                getTileOwner(indexString);
            }
            else if (Command.TILE_LAND_NEIGHBORS.matches(input)) {
                String indexString = Command.TILE_LAND_NEIGHBORS.getGroup(input, "index");
                getTileLandNeighbors(indexString);
            }
            else if (Command.TILE_SEA_NEIGHBORS.matches(input)) {
                String indexString = Command.TILE_SEA_NEIGHBORS.getGroup(input, "index");
                getTileSeaNeighbors(indexString);
            }
            else if (Command.TILE_WEATHER.matches(input)) {
                String indexString = Command.TILE_WEATHER.getGroup(input, "index");
                getTileWeather(indexString);
            }
            else if (Command.TILE_TERRAIN.matches(input)) {
                String indexString = Command.TILE_WEATHER.getGroup(input, "index");
                getTileTerrain(indexString);
            }
            else {
                Menu.invalidCommand();
            }
        }
    }

    private static void getCountryDetails(String countryName) {
        Result result = GameMenuController.getCountryDetails(countryName);
        System.out.println(result.getMessage());
    }

    private static void getTileOwner(String indexString) {
        Result result = GameMenuController.getTileOwner(indexString);
        System.out.println(result.getMessage());
    }

    private static void getTileLandNeighbors(String indexString) {
        Result result = GameMenuController.getTileLandNeighbors(indexString);
        System.out.println(result.getMessage());
    }
    private static void getTileSeaNeighbors(String indexString) {
        Result result = GameMenuController.getTileSeaNeighbors(indexString);
        System.out.println(result.getMessage());
    }

    private static void getTileWeather(String indexString) {
        Result result = GameMenuController.getTileWeather(indexString);
        System.out.println(result.getMessage());
    }

    private static void getTileTerrain(String indexString) {
        Result result = GameMenuController.getTileTerrain(indexString);
        System.out.println(result.getMessage());
    }
}
