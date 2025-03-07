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
            else if(Command.SHOW_CURRENT_MENU.matches(input)) {
                showCurrentMenu();
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
                String indexString = Command.TILE_TERRAIN.getGroup(input, "index");
                getTileTerrain(indexString);
            }
            else if (Command.SHOW_BATTALIONS.matches(input)) {
                String indexString = Command.SHOW_BATTALIONS.getGroup(input, "index");
                getTileBattalions(indexString);
            }
            else if (Command.SHOW_FACTORIES.matches(input)) {
                String indexString = Command.SHOW_FACTORIES.getGroup(input, "index");
                getTileFactories(indexString);
            }
            else if (Command.SET_TERRAIN.matches(input)) {
                String indexString = Command.SET_TERRAIN.getGroup(input, "index");
                String name = Command.SET_TERRAIN.getGroup(input, "name");
                setTileTerrain(indexString, name);
            }
            else if (Command.SET_WEATHER.matches(input)) {
                String indexString = Command.SET_WEATHER.getGroup(input, "index");
                String name = Command.SET_WEATHER.getGroup(input, "name");
                setTileWeather(indexString, name);
            }
            else if (Command.CREATE_FACTION.matches(input)) {
                String name = Command.CREATE_FACTION.getGroup(input, "name");
                createFaction(name);
            }
            else if (Command.JOIN_FACTION.matches(input)) {
                String name = Command.JOIN_FACTION.getGroup(input, "name");
                joinFaction(name);
            }
            else if (Command.LEAVE_FACTION.matches(input)) {
                String name = Command.LEAVE_FACTION.getGroup(input, "name");
                leaveFaction(name);
            }
            else if (Command.BUILD_FACTORY.matches(input)) {
                String indexString = Command.BUILD_FACTORY.getGroup(input, "index");
                String typeString = Command.BUILD_FACTORY.getGroup(input, "type");
                String name = Command.BUILD_FACTORY.getGroup(input, "name");
                buildFactory(indexString, typeString, name);
            }
            else if (Command.PUPPET.matches(input)) {
                String countryName = Command.PUPPET.getGroup(input, "countryName");
                puppet(countryName);
            }
            else {
                Menu.invalidCommand();
            }
        }
    }

    private static void showCurrentMenu() {
        System.out.println("game menu");
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

    private static void getTileBattalions(String indexString) {
        Result result = GameMenuController.getTileBattalions(indexString);
        System.out.println(result.getMessage());
    }

    private static void getTileFactories(String indexString) {
        Result result = GameMenuController.getTileFactories(indexString);
        System.out.println(result.getMessage());
    }

    private static void setTileTerrain(String indexString, String name) {
        Result result = GameMenuController.setTileTerrain(indexString, name);
        System.out.println(result.getMessage());
    }

    private static void setTileWeather(String indexString, String name) {
        Result result = GameMenuController.setTileWeather(indexString, name);
        System.out.println(result.getMessage());
    }

    private static void createFaction(String name) {
        Result result = GameMenuController.createFaction(name);
        System.out.println(result.getMessage());
    }

    private static void joinFaction(String name) {
        Result result = GameMenuController.joinFaction(name);
        System.out.println(result.getMessage());
    }

    private static void leaveFaction(String name) {
        Result result = GameMenuController.leaveFaction(name);
        System.out.println(result.getMessage());
    }

    private static void buildFactory(String indexString, String typeString, String name) {
        Result result = GameMenuController.buildFactory(indexString, typeString, name);
        System.out.println(result.getMessage());
    }

    private static void puppet(String countryName) {
        Result result = GameMenuController.puppet(countryName);
        System.out.println(result.getMessage());
    }
}
