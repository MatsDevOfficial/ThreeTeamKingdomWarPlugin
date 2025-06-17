package nl.jouwplugin;

import nl.jouwplugin.commands.JoinTeamCommand;
import nl.jouwplugin.commands.StartCommand;
import nl.jouwplugin.commands.TeamBeaconCommand;
import nl.jouwplugin.managers.BeaconManager;
import nl.jouwplugin.managers.TeamManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ThreeTeamKingdomWar extends JavaPlugin {

    private static ThreeTeamKingdomWar instance;

    private TeamManager teamManager;
    private BeaconManager beaconManager;

    @Override
    public void onEnable() {
        instance = this;

        teamManager = new TeamManager();
        beaconManager = new BeaconManager();

        getCommand("jointeam").setExecutor(new JoinTeamCommand(teamManager));
        getCommand("start").setExecutor(new StartCommand(teamManager, beaconManager));
        getCommand("teambeacon").setExecutor(new TeamBeaconCommand(beaconManager, teamManager));
    }

    public static ThreeTeamKingdomWar getInstance() {
        return instance;
    }

    public TeamManager getTeamManager() {
        return teamManager;
    }

    public BeaconManager getBeaconManager() {
        return beaconManager;
    }
}
