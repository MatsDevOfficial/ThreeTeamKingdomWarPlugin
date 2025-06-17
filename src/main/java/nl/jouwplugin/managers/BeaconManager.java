package nl.jouwplugin.managers;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

public class BeaconManager {

    private final Map<String, Location> teamBeacons = new HashMap<>();

    public void setBeaconLocation(String team, Location location) {
        teamBeacons.put(team.toLowerCase(), location);
    }

    public Location getBeaconLocation(String team) {
        return teamBeacons.get(team.toLowerCase());
    }

    public boolean hasBeacon(String team) {
        return teamBeacons.containsKey(team.toLowerCase());
    }

    public void removeBeacon(String team) {
        teamBeacons.remove(team.toLowerCase());
    }
}
