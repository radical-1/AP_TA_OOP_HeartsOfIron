package controller;

import model.Result;
import model.game.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GameMenuController {
    public static Result getCountryDetails(String countryName) {
        Country country = Country.getCountryByName(countryName);
        if (country == null) return new Result(false, "country doesn't exist");

        StringBuilder message = new StringBuilder(country + "\n");
        message.append("leader : ").append(country.getLeader().toString()).append("\n");
        message.append("stability : ").append(country.getStability()).append("\n");
        message.append("man power : ").append(country.getManpower()).append("\n");
        message.append("fuel amount : ").append(country.getFuel()).append("\n");
        message.append("sulfur : ").append(country.getSulfur()).append("\n");
        message.append("steel : ").append(country.getSteel()).append("\n");
        message.append("faction : ");
        int factionSize = country.getFactions().size();
        for (int i = 0; i < factionSize; i++) {
            message.append(country.getFactions().get(i).name());
            if (i < factionSize - 1) message.append(",");
            else message.append("\n");
        }
        message.append("puppet : ");
        int puppetSize = country.getPuppets().size();
        for (int i = 0; i < puppetSize; i++) {
            message.append(country.getPuppets().get(i).toString());
            if (i < puppetSize - 1) message.append(",");
            else message.append("\n");
        }

        return new Result(true, message.toString());
    }

    public static Result getTileOwner(String indexString) {
        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) return new Result(true, tile.getOwner().toString());
        return new Result(false, "tile doesn't exist");
    }

    public static Result getTileLandNeighbors(String indexString) {
        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) {
            StringBuilder message = new StringBuilder();
            ArrayList<Tile> neighbors = tile.getLandNeighbors();
            for (int i = 0; i < neighbors.size(); i++) {
                message.append(neighbors.get(i));
                if (i < neighbors.size() - 1) message.append(" , ");
                else message.append("\n");
            }
            return new Result(true, message.toString());
        }
        return new Result(false, "tile doesn't exist");
    }

    public static Result getTileSeaNeighbors(String indexString) {
        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) {
            StringBuilder message = new StringBuilder();
            ArrayList<Tile> neighbors = tile.getSeaNeighbors();
            for (int i = 0; i < neighbors.size(); i++) {
                message.append(neighbors.get(i));
                if (i < neighbors.size() - 1) message.append(" , ");
                else message.append("\n");
            }
            if (neighbors.isEmpty()) message.append("no sea neighbors");
            return new Result(true, message.toString());
        }
        return new Result(false, "tile doesn't exist");
    }

    public static Result getTileWeather(String indexString) {
        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) return new Result(true, tile.getWeather().toString());
        return new Result(false, "tile doesn't exist");
    }

    public static Result getTileTerrain(String indexString) {
        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) return new Result(true, tile.getTerrain().toString());
        return new Result(false, "tile doesn't exist");
    }

    public static Result getTileBattalions(String indexString) {
        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) {
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
            for (Battalion battalion: battalions) {
                if (battalion.getType() == BattalionType.NAVY)
                    message.append(battalion).append("\n");
            }

            return new Result(true, message.toString());
        }
        return new Result(false, "tile doesn't exist");
    }

    public static Result getTileFactories(String indexString) {
        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) {
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
            for (Factory factory: factories) {
                if (factory.getType() == FactoryType.SULFUR)
                    message.append(factory).append("\n");
            }

            return new Result(true, message.toString());
        }
        return new Result(false, "tile doesn't exist");
    }

    public static Result setTileTerrain(String indexString, String name) {
        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) {
            Terrain terrain = Terrain.getTerrainByName(name);
            if (terrain == null)
                return new Result(false, "terrain doesn't exist");
            tile.setTerrain(terrain);
            return new Result(true, "terrain set successfully");
        }
        return new Result(false, "tile doesn't exist");
    }

    public static Result setTileWeather(String indexString, String name) {
        int index = Integer.parseInt(indexString);
        Tile tile = Tile.getTileByIndex(index);
        if (tile != null) {
            Weather weather = Weather.getWeatherByName(name);
            if (weather == null)
                return new Result(false, "weather doesn't exist");
            tile.setWeather(weather);
            return new Result(true, "weather set successfully");
        }
        return new Result(false, "tile doesn't exist");
    }
}
