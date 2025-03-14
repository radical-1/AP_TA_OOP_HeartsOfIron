package view;

import controller.GameMenuController;
import model.Command;
import model.Result;
import model.game.Country;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenuView implements Menu {
    private static Scanner scanner;
    public static void run(Scanner scanner) {
        GameMenuView.scanner = scanner;
        while (true) {
            String input = scanner.nextLine().trim();
            if (Command.EXIT.matches(input)) {
                Menu.exit();
                break;
            }
            else if(Command.SHOW_CURRENT_MENU.matches(input)) {
                showCurrentMenu();
            }
            else if (Command.SWITCH_PLAYER.matches(input)) {
                String username = Command.SWITCH_PLAYER.getGroup(input, "username");
                switchPlayer(username);
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
            else if (Command.ADD_BATTALION.matches(input)) {
                String indexString = Command.ADD_BATTALION.getGroup(input, "index");
                String typeString = Command.ADD_BATTALION.getGroup(input, "type");
                String name = Command.ADD_BATTALION.getGroup(input, "name");
                addBattalion(indexString, typeString, name);
            }
            else if (Command.MOVE_BATTALION.matches(input)) {
                String sourceIndexString = Command.MOVE_BATTALION.getGroup(input, "source_index");
                String name = Command.MOVE_BATTALION.getGroup(input, "name");
                String destIndexString = Command.MOVE_BATTALION.getGroup(input, "dest_index");
                moveBattalion(sourceIndexString, name, destIndexString);
            }
            else if (Command.UPGRADE_BATTALION.matches(input)) {
                String indexString = Command.UPGRADE_BATTALION.getGroup(input, "index");
                String name = Command.UPGRADE_BATTALION.getGroup(input, "name");
                upgradeBattalion(indexString, name);
            }
            else if (Command.RUN_FACTORY.matches(input)) {
                String indexString = Command.RUN_FACTORY.getGroup(input, "index");
                String name = Command.RUN_FACTORY.getGroup(input, "name");
                String manpowerCountString = Command.RUN_FACTORY.getGroup(input, "manpower_count");
                runFactory(indexString, name, manpowerCountString);
            }
            else if (Command.ATTACK.matches(input)) {
                String sourceIndexString = Command.ATTACK.getGroup(input, "source_index");
                String destIndexString = Command.ATTACK.getGroup(input, "dest_index");
                String typeString = Command.ATTACK.getGroup(input, "battalion_type");
                attack(sourceIndexString, destIndexString, typeString);
            }
            else if (Command.CIVIL_WAR.matches(input)) {
                String firstIndexString = Command.CIVIL_WAR.getGroup(input, "first_index");
                String secondIndexString = Command.CIVIL_WAR.getGroup(input, "second_index");
                String typeString = Command.CIVIL_WAR.getGroup(input, "battalion_type");
                civilWar(firstIndexString, secondIndexString, typeString);
            }
            else if (Command.START_ELECTION.matches(input)) {
                startElection();
                getLeaderForElection();
            }
            else if (Command.END.matches(input)) {
                end(scanner);
            }
            else {
                Menu.invalidCommand();
            }
        }
    }

    private static void showCurrentMenu() {
        System.out.println("game menu");
    }

    private static void chooseCountry(ArrayList<String> countryNames) {
        Result result = GameMenuController.chooseCountry(countryNames);
        if (!result.isValid()) System.out.println(result.getMessage());
    }

    private static void switchPlayer(String username) {
        Result result = GameMenuController.switchPlayer(username);
        System.out.println(result.getMessage());
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

    private static void addBattalion(String indexString, String typeString, String name) {
        Result result = GameMenuController.addBattalion(indexString, typeString, name);
        System.out.println(result.getMessage());
    }

    private static void moveBattalion(String sourceIndexString, String name, String destIndexString) {
        Result result = GameMenuController.moveBattalion(sourceIndexString, name, destIndexString);
        System.out.println(result.getMessage());
    }

    private static void upgradeBattalion(String indexString, String name) {
        Result result = GameMenuController.upgradeBattalion(indexString, name);
        System.out.println(result.getMessage());
    }

    private static void runFactory(String indexString, String name, String manpowerCountString) {
        Result result = GameMenuController.runFactory(indexString, name, manpowerCountString);
        System.out.println(result.getMessage());
    }

    private static void attack(String sourceIndexString, String destIndexString, String typeString) {
        Result result = GameMenuController.attack(sourceIndexString, destIndexString, typeString);
        System.out.println(result.getMessage());
    }

    private static void civilWar(String firstIndexString, String secondIndexString, String typeString) {
        Result result = GameMenuController.civilWar(firstIndexString, secondIndexString, typeString);
        System.out.println(result.getMessage());
    }

    private static void startElection() {
        Result result = GameMenuController.startElection();
        System.out.println(result.getMessage());
    }

    private static void getLeaderForElection() {
        String input = scanner.nextLine().trim();
        Result result = GameMenuController.getLeaderForElection(input);
        if (!result.isValid())
            System.out.println(result.getMessage());
    }

    private static void end(Scanner scanner) {
        GameMenuController.end();
        MainMenuView.run(scanner);
    }
}
