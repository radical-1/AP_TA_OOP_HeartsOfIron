package controller;

import model.*;
import model.game.*;

import java.util.ArrayList;
import java.util.Comparator;

public class GameMenuController {

    private static boolean isGameLocked() {
        Country current = Game.currentPlayer.getCountry();
        switch (current.getLeader().getIdeology()) {
            case DEMOCRACY:
                if (current.getStability() < 50) return true;
            case COMMUNISM:
                if (current.getStability() < 60) return true;
            case FASCISM:
                if (current.getStability() < 30) return true;
        }
        return false;
    }

    public static Result switchPlayer(String username) {
        User user = User.getUserByUsername(username);
        Guest guest = Guest.getGuestByUsername(username);
        Player player;
        if (user == null && guest == null)
            return new Result(false, "player doesn't exist");
        if (user == null) player = guest;
        else player = user;
        if (!Game.currentGame.getPlayers().contains(player))
            return new Result(false, "player doesn't exist");
        if (player == Game.currentPlayer)
            return new Result(false, "you can't switch to yourself");
        Game.currentPlayer = player;
        return new Result(true, "switched to " + username);
    }

    public static Result getCountryDetails(String countryName) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        Country country = Country.getCountryByName(countryName);
        if (country == null) return new Result(false, "country doesn't exist");

        StringBuilder message = new StringBuilder(country + "\n");
        message.append("leader : ").append(country.getLeader().toString()).append("\n");
        message.append("stability : ").append(country.getStability()).append("\n");
        message.append("man power : ").append(country.getManpower()).append("\n");
        message.append("fuel : ").append(country.getFuel()).append("\n");
        message.append("sulfur : ").append(country.getSulfur()).append("\n");
        message.append("steel : ").append(country.getSteel()).append("\n");
        message.append("faction : ");
        ArrayList<Faction> factions = new ArrayList<>();
        for (Faction faction: Faction.getAllFactions()) {
            if (faction.countryExists(country)) factions.add(faction);
        }
        for (int i = 0; i < factions.size(); i++) {
            message.append(factions.get(i).toString());
            if (i < factions.size() - 1) message.append(",");
            else message.append("\n");
        }
        if (factions.isEmpty()) message.append("\n");
        message.append("puppet : ");
        int puppetSize = country.getPuppets().size();
        for (int i = 0; i < puppetSize; i++) {
            message.append(country.getPuppets().get(i).toString());
            if (i < puppetSize - 1) message.append(",");
        }

        return new Result(true, message.toString().trim());
    }

    public static Result getTileOwner(String indexString) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) return new Result(true, tile.getOwner().toString());
        return new Result(false, "tile doesn't exist");
    }

    public static Result getTileLandNeighbors(String indexString) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) {
            StringBuilder message = new StringBuilder();
            ArrayList<Tile> neighbors = tile.getLandNeighbors();
            for (int i = 0; i < neighbors.size(); i++) {
                message.append(neighbors.get(i));
                if (i < neighbors.size() - 1) message.append(" , ");
            }
            return new Result(true, message.toString());
        }
        return new Result(false, "tile doesn't exist");
    }

    public static Result getTileSeaNeighbors(String indexString) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) {
            StringBuilder message = new StringBuilder();
            ArrayList<Tile> neighbors = tile.getSeaNeighbors();
            for (int i = 0; i < neighbors.size(); i++) {
                message.append(neighbors.get(i));
                if (i < neighbors.size() - 1) message.append(" , ");
            }
            if (neighbors.isEmpty()) message.append("no sea neighbors");
            return new Result(true, message.toString());
        }
        return new Result(false, "tile doesn't exist");
    }

    public static Result getTileWeather(String indexString) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) return new Result(true, tile.getWeather().toString());
        return new Result(false, "tile doesn't exist");
    }

    public static Result getTileTerrain(String indexString) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) return new Result(true, tile.getTerrain().toString());
        return new Result(false, "tile doesn't exist");
    }

    public static Result getTileBattalions(String indexString) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) {
            Country owner = tile.getOwner();
            Country current = Game.currentPlayer.getCountry();
            if (owner != current && !current.isPuppet(owner) && !isSameFaction(owner, current))
                return new Result(false, "can't show battalions");

            ArrayList<Battalion> battalions = tile.getBattalions();
            battalions.sort(Comparator.comparing(Battalion::getName));

            StringBuilder message = new StringBuilder();
            message.append("infantry:\n");
            for (Battalion battalion: battalions) {
                if (battalion.getType() == BattalionType.INFANTRY)
                    message.append(battalion).append("\n");
            }
            message.append("\n");

            message.append("panzer:\n");
            for (Battalion battalion: battalions) {
                if (battalion.getType() == BattalionType.PANZER)
                    message.append(battalion).append("\n");
            }
            message.append("\n");

            message.append("airforce:\n");
            for (Battalion battalion: battalions) {
                if (battalion.getType() == BattalionType.AIRFORCE)
                    message.append(battalion).append("\n");
            }
            message.append("\n");

            message.append("navy:\n");
            for (Battalion battalion : battalions) {
                if (battalion.getType() == BattalionType.NAVY)
                    message.append(battalion).append("\n");
            }

            return new Result(true, message.toString().trim());
        }
        return new Result(false, "tile doesn't exist");
    }

    public static Result getTileFactories(String indexString) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) {
            Country owner = tile.getOwner();
            Country current = Game.currentPlayer.getCountry();
            if (owner != current && !current.isPuppet(owner) && !isSameFaction(owner, current))
                return new Result(false, "can't show factories");

            ArrayList<Factory> factories = tile.getFactories();
            factories.sort(Comparator.comparing(Factory::getName));

            StringBuilder message = new StringBuilder();
            message.append("fuel refinery:\n");
            for (Factory factory: factories) {
                if (factory.getType() == FactoryType.FUEL)
                    message.append(factory).append("\n");
            }
            message.append("\n");

            message.append("steel factory:\n");
            for (Factory factory: factories) {
                if (factory.getType() == FactoryType.STEEL)
                    message.append(factory).append("\n");
            }
            message.append("\n");

            message.append("sulfur factory:\n");
            for (Factory factory : factories) {
                if (factory.getType() == FactoryType.SULFUR)
                    message.append(factory).append("\n");
            }

            return new Result(true, message.toString().trim());
        }
        return new Result(false, "tile doesn't exist");
    }

    private static boolean isSameFaction(Country c1, Country c2) {
        for (Faction faction: Faction.getAllFactions()) {
            if (faction.countryExists(c1) && faction.countryExists(c2))
                return true;
        }
        return false;
    }

    public static Result setTileTerrain(String indexString, String name) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) {
            Terrain terrain = Terrain.getTerrainByName(name);
            Country owner = tile.getOwner();
            Country current = Game.currentPlayer.getCountry();
            if (owner != current)
                return new Result(false, "you don't own this tile");
            if (terrain == null)
                return new Result(false, "terrain doesn't exist");
            if (tile.isTerrainChanged())
                return new Result(false, "you can't change terrain twice");

            tile.setTerrain(terrain);
            tile.setTerrainChanged();
            return new Result(true, "terrain set successfully");
        }
        return new Result(false, "tile doesn't exist");
    }

    public static Result setTileWeather(String indexString, String name) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) {
            Weather weather = Weather.getWeatherByName(name);
            Country owner = tile.getOwner();
            Country current = Game.currentPlayer.getCountry();
            if (owner != current)
                return new Result(false, "you don't own this tile");
            if (weather == null)
                return new Result(false, "weather doesn't exist");

            tile.setWeather(weather);
            return new Result(true, "weather set successfully");
        }
        return new Result(false, "tile doesn't exist");
    }

    public static Result createFaction(String name) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        Faction faction = Faction.getFactionByName(name);
        if (faction != null)
            return new Result(false, "faction name already taken");
        Country current = Game.currentPlayer.getCountry();
        Faction createdFaction = new Faction(name);
        createdFaction.addCountry(current);
        return new Result(true, "faction created successfully");
    }

    public static Result joinFaction(String name) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        Faction faction = Faction.getFactionByName(name);
        if (faction == null)
            return new Result(false, "faction doesn't exist");
        Country country = Game.currentPlayer.getCountry();
        faction.addCountry(country);
        return new Result(true, country + " joined " + faction);
    }

    public static Result leaveFaction(String name) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        Faction faction = Faction.getFactionByName(name);
        if (faction == null)
            return new Result(false, "faction doesn't exist");
        Country country = Game.currentPlayer.getCountry();
        if (!faction.countryExists(country))
            return new Result(false, "your country isn't in this faction");
        faction.removeCountry(country);
        return new Result(true, country + " left " + faction);
    }

    public static Result buildFactory(String indexString, String typeString, String name) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        Tile tile = Tile.getTileByIndex(Integer.parseInt(indexString));
        if (tile == null)
            return new Result(false, "invalid tile");
        Country owner = tile.getOwner();
        Country current = Game.currentPlayer.getCountry();
        if (owner != current && !current.isPuppet(owner) && !isSameFaction(owner, current))
            return new Result(false, "invalid tile");
        FactoryType type = FactoryType.getFactoryTypeByName(typeString);
        if (type == null)
            return new Result(false, "invalid factory type");
        if (!enoughMoneyExists(tile, type))
            return new Result(false, "not enough money to build factory");
        if (reachedMaximum(tile, type))
            return new Result(false, "factory limit exceeded");

        Factory factory = new Factory(type, name);
        tile.addFactory(factory);
        return new Result(true, "factory built successfully");
    }

    public static Result runFactory(String indexString, String name, String manpowerCountString) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        int index = Integer.parseInt(indexString);
        int manpowerCount = Integer.parseInt(manpowerCountString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile == null)
            return new Result(false, "invalid tile");
        Country owner = tile.getOwner();
        Country current = Game.currentPlayer.getCountry();
        if (owner != current && !current.isPuppet(owner) && !isSameFaction(owner, current))
            return new Result(false, "invalid tile");
        Factory factory = getFactoryByName(tile, name);
        if (factory == null)
            return new Result(false, "this tile doesn't contain this factory");
        if (current.isPuppet(owner) || isSameFaction(owner, current)) {
            if (current.getManpower() < manpowerCount)
                return new Result(false, "you are poor!");
        } else {
            if (owner.getManpower() < manpowerCount)
                return new Result(false, "you are poor!");
        }

        double extractAmount = getExtractAmount(factory, tile, manpowerCount);
        if (factory.getRemainingResource() <= extractAmount) tile.removeFactory(factory);
        else factory.useResource(extractAmount);
        if (current.isPuppet(owner) || isSameFaction(owner, current)) {
            current.decreaseManpower(manpowerCount);
            if (current.getLeader().getIdeology() == Ideology.COMMUNISM)
                communistDivision(current, factory.getType(), extractAmount);
            else current.addResource(factory.getType(), extractAmount);
        }
        else {
            owner.decreaseManpower(manpowerCount);
            if (owner.getLeader().getIdeology() == Ideology.COMMUNISM)
                communistDivision(owner, factory.getType(), extractAmount);
            else owner.addResource(factory.getType(), extractAmount);
        }
        return new Result(true, "factory extracted " + extractAmount + " of " + factory.getType());
    }

    private static void communistDivision(Country communist, FactoryType type, double extractAmount)  {
        int count = 0;
        for (Country country: Country.values()) {
            if (isSameFaction(country, communist)) count++;
        }
        double portion = extractAmount / count;
        for (Country country: Country.values()) {
            if (isSameFaction(country, communist)) country.addResource(type, portion);
        }
    }

    private static double getExtractAmount(Factory factory, Tile tile, int manpowerCount) {
        double productionPerManpower = factory.getType().getProductionPerManpower();
        if (factory.getType() == FactoryType.FUEL) {
            switch (tile.getTerrain()) {
                case URBAN:
                    productionPerManpower *= 0.2;
                    break;
                case MOUNTAIN:
                case FOREST:
                    productionPerManpower = 0;
                    break;
            }
        }

        return manpowerCount * productionPerManpower;
    }

    private static Factory getFactoryByName(Tile tile, String name) {
        for (Factory factory: tile.getFactories()) {
            if (factory.getName().equals(name))
                return factory;
        }
        return null;
    }

    private static boolean reachedMaximum(Tile tile, FactoryType factoryType) {
        int count = 0;
        for (Factory factory: tile.getFactories()) {
            if (factory.getType() == factoryType) count++;
        }
        return count == 3;
    }

    private static boolean enoughMoneyExists(Tile tile, FactoryType type) {
        Country owner = tile.getOwner();

        double manpowerCost = type.getManpowerCost();
        double steelCost = type.getSteelCost();

        if (owner.getLeader().getIdeology() == Ideology.COMMUNISM) {
            manpowerCost *= 0.5;
            steelCost *= 0.5;
        }

        switch (tile.getTerrain()) {
            case MOUNTAIN:
                manpowerCost *= 10;
                steelCost *= 10;
                break;
            case FOREST:
                manpowerCost *= 5;
                steelCost *= 5;
                break;
            case URBAN:
                manpowerCost *= 0.1;
                steelCost *= 0.1;
                break;
        }

        return  owner.getSteel() >= steelCost &&
                owner.getManpower() >= manpowerCost;
    }

    public static Result puppet(String countryName) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        Country puppet = Country.getCountryByName(countryName);
        if (puppet == null)
            return new Result(false, "country doesn't exist");
        if (!canPuppet(puppet))
            return new Result(false, "you are not allowed to puppet this country");
        Country current = Game.currentPlayer.getCountry();
        current.addPuppet(puppet);
        return new Result(true, "now " + countryName + " is my puppet yo ho ha ha ha");
    }

    private static boolean canPuppet(Country country) {
        Country current = Game.currentPlayer.getCountry();
        if (current.getLeader().getIdeology() == Ideology.DEMOCRACY) return false;
        if (current.getManpower() <= country.getManpower()) return false;
        if (isSameFaction(current, country)) return false;
        return true;
    }

    public static Result addBattalion(String indexString, String typeString, String name) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) {
            Country owner = tile.getOwner();
            Country current = Game.currentPlayer.getCountry();
            if (owner != current && !current.isPuppet(owner) && !isSameFaction(owner, current))
                return new Result(false, "tile is unavailable");
            BattalionType type = BattalionType.getBattalionTypeByName(typeString);
            if (type == null)
                return new Result(false, "you can't use imaginary battalions");
            if (isBattalionNameRepeatedInTile(tile, name))
                return new Result(false, "battalion name already taken");
            if (!enoughMoneyExists(tile, type))
                return new Result(false, "daddy USA plz help us");
            if (reachedMaximum(tile, type))
                return new Result(false, "you can't add this type of battalion anymore");

            payBattalionCreation(tile, type);
            Battalion battalion = new Battalion(name, type, owner);
            tile.addBattalion(battalion);
            return new Result(true, "battalion set successfully");
        }
        return new Result(false, "tile is unavailable");
    }

    private static void payBattalionCreation(Tile tile, BattalionType type) {
        Country owner = tile.getOwner();

        double fuel = type.getFuel();
        double steel = type.getSteel();
        double sulfur = type.getSulfur();
        double manpower = type.getManpower();

        if (owner.getLeader().getIdeology() == Ideology.DEMOCRACY) {
            fuel *= 2;
            steel *= 2;
            sulfur *= 2;
            manpower *= 2;
        }

        switch (tile.getTerrain()) {
            case MOUNTAIN:
                fuel *= 10;
                steel *= 10;
                sulfur *= 10;
                manpower *= 10;
                break;
            case FOREST:
                fuel *= 5;
                steel *= 5;
                sulfur *= 5;
                manpower *= 5;
                break;
            case URBAN:
                fuel *= 0.1;
                steel *= 0.1;
                sulfur *= 0.1;
                manpower *= 0.1;
                break;
        }

        owner.decreaseFuel(fuel);
        owner.decreaseSteel(steel);
        owner.decreaseSulfur(sulfur);
        owner.decreaseManpower(manpower);
    }

    private static boolean isBattalionNameRepeatedInTile(Tile tile, String name) {
        for (Battalion battalion: tile.getBattalions()) {
            if (battalion.getName().equals(name)) return true;
        }
        return false;
    }

    private static boolean enoughMoneyExists(Tile tile, BattalionType type) {
        Country owner = tile.getOwner();

        double fuel = type.getFuel();
        double steel = type.getSteel();
        double sulfur = type.getSulfur();
        double manpower = type.getManpower();

        if (owner.getLeader().getIdeology() == Ideology.DEMOCRACY) {
            fuel *= 2;
            steel *= 2;
            sulfur *= 2;
            manpower *= 2;
        }

        switch (tile.getTerrain()) {
            case MOUNTAIN:
                fuel *= 10;
                steel *= 10;
                sulfur *= 10;
                manpower *= 10;
                break;
            case FOREST:
                fuel *= 5;
                steel *= 5;
                sulfur *= 5;
                manpower *= 5;
                break;
            case URBAN:
                fuel *= 0.1;
                steel *= 0.1;
                sulfur *= 0.1;
                manpower *= 0.1;
                break;
        }


        return  owner.getFuel() >= fuel &&
                owner.getSteel() >= steel &&
                owner.getSulfur() >= sulfur &&
                owner.getManpower() >= manpower;
    }

    private static boolean reachedMaximum(Tile tile, BattalionType battalionType) {
        int count = 0;
        for (Battalion battalion : tile.getBattalions()) {
            if (battalion.getType() == battalionType) count++;
        }
        return count == 3;
    }

    public static Result moveBattalion(String sourceIndexString, String name, String destIndexString) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        int sourceIndex = Integer.parseInt(sourceIndexString);
        int destIndex = Integer.parseInt(destIndexString);
        Tile source = Tile.getTileByIndex(sourceIndex);
        Tile dest = Tile.getTileByIndex(destIndex);
        if (source != null && dest != null) {
            Country sourceOwner = source.getOwner();
            Country destOwner = dest.getOwner();
            Country current = Game.currentPlayer.getCountry();
            if (sourceOwner != current && !current.isPuppet(sourceOwner) && !isSameFaction(sourceOwner, current))
                return new Result(false, "tile is unavailable");
            if (destOwner != current && !current.isPuppet(destOwner) && !isSameFaction(destOwner, current))
                return new Result(false, "tile is unavailable");

            Battalion battalion = getBattalionByName(source, name);
            if (battalion == null)
                return new Result(false, "no battalion with the given name");
            if (reachedMaximum(dest, battalion.getType()))
                return new Result(false, "maximum battalion of this type in destination exists");
            if (isBattalionNameRepeatedInTile(dest, name))
                return new Result(false, "battalion name is already taken in this tile");

            source.removeBattalion(battalion);
            dest.addBattalion(battalion);
            return new Result(true, "battalion moved successfully");
        }
        return new Result(false, "tile is unavailable");
    }

    private static Battalion getBattalionByName(Tile tile, String name) {
        for (Battalion battalion : tile.getBattalions()) {
            if (battalion.getName().equals(name)) return battalion;
        }
        return null;
    }

    public static Result upgradeBattalion(String indexString, String name) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) {
            Country owner = tile.getOwner();
            Country current = Game.currentPlayer.getCountry();
            if (owner != current && !current.isPuppet(owner) && !isSameFaction(owner, current))
                return new Result(false, "can't upgrade battalions on this tile");

            Battalion battalion = getBattalionByName(tile, name);
            if (battalion == null)
                return new Result(false, "no battalion with the given name");
            if (battalion.getLevel() == 3)
                return new Result(false, "battalion is on highest level");
            if (!enoughMoneyExists(tile, battalion))
                return new Result(false, "aww you can't upgrade your battalion");

            upgradeBattalion(tile, battalion);
            return new Result(true, name + " upgraded to level " + battalion.getLevel());
        }
        return new Result(false, "tile doesn't exist");
    }



    private static boolean enoughMoneyExists(Tile tile, Battalion battalion) {
        Country owner = tile.getOwner();
        BattalionType type = battalion.getType();
        int level = battalion.getLevel();

        double fuel = type.getFuel();
        double steel = type.getSteel();
        double sulfur = type.getSulfur();
        double manpower = type.getManpower();

        if (owner.getLeader().getIdeology() == Ideology.DEMOCRACY) {
            fuel *= 2;
            steel *= 2;
            sulfur *= 2;
            manpower *= 2;
        }
        switch (tile.getTerrain()) {
            case MOUNTAIN:
                fuel *= 10;
                steel *= 10;
                sulfur *= 10;
                manpower *= 10;
                break;
            case FOREST:
                fuel *= 5;
                steel *= 5;
                sulfur *= 5;
                manpower *= 5;
                break;
            case URBAN:
                fuel *= 0.1;
                steel *= 0.1;
                sulfur *= 0.1;
                manpower *= 0.1;
                break;
        }

        return switch (level) {
            case 0 -> owner.getFuel() >= 0.5 * fuel &&
                      owner.getSteel() >= 0.5 * steel &&
                      owner.getSulfur() >= 0.5 * sulfur &&
                      owner.getManpower() >= 0.5 * manpower;
            case 1 -> owner.getFuel() >= fuel &&
                      owner.getSteel() >= steel &&
                      owner.getSulfur() >= sulfur &&
                      owner.getManpower() >= manpower;
            case 2 -> owner.getFuel() >= 2 * fuel &&
                      owner.getSteel() >= 2 * steel &&
                      owner.getSulfur() >= 2 * sulfur &&
                      owner.getManpower() >= 2 * manpower;
            default -> false;
        };
    }

    private static void upgradeBattalion(Tile tile, Battalion battalion) {
        Country owner = tile.getOwner();
        BattalionType type = battalion.getType();
        int level = battalion.getLevel();

        double fuel = type.getFuel();
        double steel = type.getSteel();
        double sulfur = type.getSulfur();
        double manpower = type.getManpower();

        if (owner.getLeader().getIdeology() == Ideology.DEMOCRACY) {
            fuel *= 2;
            steel *= 2;
            sulfur *= 2;
            manpower *= 2;
        }

        switch (tile.getTerrain()) {
            case MOUNTAIN:
                fuel *= 10;
                steel *= 10;
                sulfur *= 10;
                manpower *= 10;
                break;
            case FOREST:
                fuel *= 5;
                steel *= 5;
                sulfur *= 5;
                manpower *= 5;
                break;
            case URBAN:
                fuel *= 0.1;
                steel *= 0.1;
                sulfur *= 0.1;
                manpower *= 0.1;
                break;
        }

        battalion.upgradeLevel();

        switch (level) {
            case 0: owner.decreaseFuel(0.5 * fuel);
                    owner.decreaseSteel(0.5 * steel);
                    owner.decreaseSulfur(0.5 * sulfur);
                    owner.decreaseManpower(0.5 * manpower);
                    battalion.increasePower(5);
                    break;
            case 1: owner.decreaseFuel(fuel);
                    owner.decreaseSteel(steel);
                    owner.decreaseSulfur(sulfur);
                    owner.decreaseManpower(manpower);
                    battalion.increasePower(7);
                    break;
            case 2: owner.decreaseFuel(2 * fuel);
                    owner.decreaseSteel(2 * steel);
                    owner.decreaseSulfur(2 * sulfur);
                    owner.decreaseManpower(2 * manpower);
                    battalion.increasePower(10);
                    break;
        }
    }

    public static Result attack(String sourceIndexString, String destIndexString, String typeString) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        int sourceIndex = Integer.parseInt(sourceIndexString);
        int destIndex = Integer.parseInt(destIndexString);
        BattalionType type = BattalionType.getBattalionTypeByName(typeString);

        Tile source = Tile.getTileByIndex(sourceIndex);
        Tile dest = Tile.getTileByIndex(destIndex);
        if (source != null) {
            Country owner = source.getOwner();
            Country current = Game.currentPlayer.getCountry();
            if (current != owner && !current.isPuppet(owner))
                return new Result(false, "attacker tile unavailable");

            if (!hasBattalionType(source, type))
                return new Result(false, "selected tile doesn't have this type of battalion");

            if (dest == null || !canAttack(source, dest, type))
                return new Result(false, "enemy tile unavailable for attacking");

            if (isFascist(source) && isFascist(dest))
                return new Result(false, "we are rivals , not enemies");

            return attack(source, dest, type);

        }
        return new Result(false, "attacker tile unavailable");
    }

    private static Result attack(Tile source, Tile dest, BattalionType type) {
        double sourcePower = 0;
        int sourceCount = 0;
        for (Battalion battalion: source.getBattalions()) {
            if (battalion.getType() == type) {
                sourcePower += battalion.getPower();
                sourceCount++;
            }
        }
        sourcePower = sourcePower * source.getTerrain().getModifier(type) * source.getWeather().getModifier(type);

        double destPower = 0;
        int destCount = 0;
        for (Battalion battalion: dest.getBattalions()) {
            if (battalion.getType() == type) {
                destPower += battalion.getPower();
                destCount++;
            }
        }
        destPower = destPower * dest.getTerrain().getModifier(type) * dest.getWeather().getModifier(type);

        ArrayList<Battalion> deletions = new ArrayList<>();
        double capturedPower = 0;

        if (sourcePower > destPower) {

            for (Battalion battalion: dest.getBattalions()) {
                if (battalion.getType() == type) {
                    capturedPower += battalion.getPower() * dest.getTerrain().getModifier(type) * dest.getWeather().getModifier(type) * battalion.getCaptureRatio() * 0.01;
                    deletions.add(battalion);
                }
            }
            for (Battalion battalion: source.getBattalions()) {
                if (battalion.getType() == type) {
                    battalion.increasePower(capturedPower / sourceCount);
                }
            }

            source.getOwner().increaseStability();
            dest.getOwner().decreaseStability();

            dest.setOwner(source.getOwner());

            for (Battalion battalion: deletions) dest.removeBattalion(battalion);

            calculateScores(true, sourcePower - destPower, type);

            return new Result(true, "war is over\n" +
                    "winner : " + source.getOwner().toString() + "\n" +
                    "loser : " + dest.getOwner().toString());
        }

        else if (destPower > sourcePower) {
            for (Battalion battalion: source.getBattalions()) {
                if (battalion.getType() == type) {
                    capturedPower += battalion.getPower() * source.getTerrain().getModifier(type) * source.getWeather().getModifier(type) * battalion.getCaptureRatio() * 0.01;
                    deletions.add(battalion);
                }
            }
            for (Battalion battalion: dest.getBattalions()) {
                if (battalion.getType() == type) {
                    battalion.increasePower(capturedPower / destCount);
                }
            }
            for (Battalion battalion: deletions) source.removeBattalion(battalion);

            dest.getOwner().increaseStability();
            source.getOwner().decreaseStability();

            dest.getOwner().increaseSteel((destPower - sourcePower) * 100);
            dest.getOwner().increaseSulfur((destPower - sourcePower) * 100);
            dest.getOwner().increaseFuel((destPower - sourcePower) * 100);

            calculateScores(false, destPower - sourcePower, type);

            return new Result(true, "war is over\n" +
                    "winner : " + dest.getOwner().toString() + "\n" +
                    "loser : " + source.getOwner().toString());
        }

        else {
            for (Battalion battalion: dest.getBattalions()) {
                if (battalion.getType() == type) deletions.add(battalion);
            }
            for (Battalion battalion: deletions) dest.removeBattalion(battalion);

            deletions.clear();

            for (Battalion battalion: source.getBattalions()) {
                if (battalion.getType() == type) deletions.add(battalion);
            }
            for (Battalion battalion: deletions) source.removeBattalion(battalion);

            return new Result(true, "draw");
        }
    }

    private static void calculateScores(boolean win, double powerDifference, BattalionType type) {
        Player player = Game.currentPlayer;
        int battalionModifier = switch (type) {
            case INFANTRY -> 5;
            case PANZER -> 7;
            case NAVY -> 10;
            case AIRFORCE -> 15;
        };
        if (win)
            player.increaseScore(powerDifference * 10 * battalionModifier);
        else
            player.decreaseScore(powerDifference * 5 * battalionModifier);
    }

    private static boolean hasBattalionType(Tile tile, BattalionType type) {
        boolean flag = false;
        for (Battalion battalion: tile.getBattalions()) {
            flag = (battalion.getType() == type);
        }
        return flag;
    }

    private static boolean canAttack(Tile source, Tile dest, BattalionType type) {
        if (isSameFaction(source.getOwner(), dest.getOwner())) return false;
        if (dest.getOwner().isPuppet(source.getOwner())) return false;
        if (type == BattalionType.INFANTRY || type == BattalionType.PANZER)
            return source.isLandNeighbor(dest);
        if (type == BattalionType.NAVY)
            return source.isSeaNeighbor(dest);
        return true;
    }

    private static boolean isFascist(Tile tile) {
        return tile.getOwner().getLeader().getIdeology() == Ideology.FASCISM;
    }

    public static Result civilWar(String firstIndexString, String secondIndexString, String typeString) {
        if (isGameLocked())
            return new Result(false, "game is locked");

        Tile first = Tile.getTileByIndex(Integer.parseInt(firstIndexString));
        Tile second = Tile.getTileByIndex(Integer.parseInt(secondIndexString));
        BattalionType type = BattalionType.getBattalionTypeByName(typeString);

        Country current = Game.currentPlayer.getCountry();
        if (current.getLeader().getIdeology() == Ideology.DEMOCRACY)
            return new Result(false, "no civil war for you");
        if (first != null && second != null) {
            if (first.getOwner() != current || second.getOwner() != current)
                return new Result(false, "invalid tiles for civil war");
            if ((type == BattalionType.INFANTRY || type == BattalionType.PANZER)) {
                if (!first.isLandNeighbor(second))
                    return new Result(false, "can't start civil war between these tiles");
            }
            if (type == BattalionType.NAVY) {
                if (!first.isSeaNeighbor(second))
                    return new Result(false, "can't start civil war between these tiles");
            }
            if (type == null)
                return new Result(false, "invalid battalion type");


            current.decreaseStability(0.1);
            return civilAttack(first, second, type);
        }

        return new Result(false, "null values");
    }

    private static Result civilAttack(Tile first, Tile second, BattalionType type) {
        double firstPower = 0;
        int firstCount = 0;
        for (Battalion battalion: first.getBattalions()) {
            if (battalion.getType() == type) {
                firstPower += battalion.getPower();
                firstCount++;
            }
        }
        firstPower = firstPower * first.getTerrain().getModifier(type) * first.getWeather().getModifier(type);

        double secondPower = 0;
        int secondCount = 0;
        for (Battalion battalion: second.getBattalions()) {
            if (battalion.getType() == type) {
                secondPower += battalion.getPower();
                secondCount++;
            }
        }
        secondPower = secondPower * second.getTerrain().getModifier(type) * second.getWeather().getModifier(type);

        ArrayList<Battalion> deletions = new ArrayList<>();
        double capturedPower = 0;

        if (firstPower > secondPower) {

            for (Battalion battalion: second.getBattalions()) {
                if (battalion.getType() == type) {
                    capturedPower += battalion.getPower() * second.getTerrain().getModifier(type) * second.getWeather().getModifier(type) * battalion.getCaptureRatio() * 0.01;
                    deletions.add(battalion);
                }
            }
            for (Battalion battalion: first.getBattalions()) {
                if (battalion.getType() == type) {
                    battalion.increasePower(capturedPower / firstCount);
                }
            }

            for (Battalion battalion: deletions) second.removeBattalion(battalion);
            return new Result(true, "civil war ended. " + first.getIndex() + " won.");
        }
        else if (secondPower > firstPower) {
            for (Battalion battalion: first.getBattalions()) {
                if (battalion.getType() == type) {
                    capturedPower += battalion.getPower() * first.getTerrain().getModifier(type) * first.getWeather().getModifier(type) * battalion.getCaptureRatio() * 0.01;
                    deletions.add(battalion);
                }
            }
            for (Battalion battalion: second.getBattalions()) {
                if (battalion.getType() == type) {
                    battalion.increasePower(capturedPower / secondCount);
                }
            }
            for (Battalion battalion: deletions) first.removeBattalion(battalion);

            return new Result(true, "civil war ended. " + second.getIndex() + " won.");
        }
        else {
            for (Battalion battalion: second.getBattalions()) {
                if (battalion.getType() == type) deletions.add(battalion);
            }
            for (Battalion battalion: deletions) second.removeBattalion(battalion);

            deletions.clear();

            for (Battalion battalion: first.getBattalions()) {
                if (battalion.getType() == type) deletions.add(battalion);
            }
            for (Battalion battalion: deletions) first.removeBattalion(battalion);

            return new Result(true, "man dige harfi nadaram.");
        }
    }

    public static Result startElection() {
        StringBuilder message = new StringBuilder();
        message.append("Available leaders:\n");
        Country current = Game.currentPlayer.getCountry();
        for (Leader leader: Leader.values()) {
            if (leader.getIdeology() == Ideology.DEMOCRACY && leader.getCountry() == current)
                message.append(leader).append("\n");
        }
        for (Leader leader: Leader.values()) {
            if (leader.getIdeology() == Ideology.COMMUNISM && leader.getCountry() == current)
                message.append(leader).append("\n");
        }
        for (Leader leader: Leader.values()) {
            if (leader.getIdeology() == Ideology.FASCISM && leader.getCountry() == current)
                message.append(leader).append("\n");
        }
        return new Result(true, message.toString().trim());
    }

    public static Result getLeaderForElection(String leaderName) {
        Leader leader = Leader.getLeaderByName(leaderName);
        if (leader == null)
            return new Result(false, "leader doesn't exist");
        Country current = Game.currentPlayer.getCountry();
        current.setLeader(leader);
        current.rechargeStability();
        return new Result(true, "");
    }

    public static Result getCountry(Player player, String name) {
        Country country = Country.getCountryByName(name);
        if (country == null)
            return new Result(false, "wrong country name");
        if (isCountryTaken(country))
            return new Result(false, "country already taken");
        player.setCountry(country);
        return new Result(true, "");
    }

    private static boolean isCountryTaken(Country country) {
        ArrayList<Player> players = Game.currentGame.getPlayers();
        for (Player player: players) {
            if (player.getCountry() == country) return true;
        }
        return false;
    }

    public static Result jewSulfur(String jewCountString) {
        int jewCount = Integer.parseInt(jewCountString);
        Country current = Game.currentPlayer.getCountry();
        if (current == Country.GERMAN_REICH && current.getLeader() == Leader.HITLER) {
            if (current.getManpower() < jewCount)
                return new Result(false, "not enough jew");
            current.increaseSulfur(jewCount * 100);
            return new Result(true, "jews transformed successfully");
        }
        return null;
    }

    public static void end() {
        for (Player player: Game.currentGame.getPlayers()) {
            if (player.getCountry().getLeader().getIdeology() == Ideology.FASCISM)
                player.increaseScore(player.getScore() * 2);
        }
    }
}
