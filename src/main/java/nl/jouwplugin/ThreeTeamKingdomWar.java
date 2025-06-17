package nl.jouwplugin;

import nl.jouwplugin.commands.*;
import nl.jouwplugin.managers.*;
import org.bukkit.plugin.java.JavaPlugin;

public class ThreeTeamKingdomWar extends JavaPlugin {

    private static ThreeTeamKingdomWar instance;

    private TeamManager teamManager;
    private BeaconManager beaconManager;
    private PhaseManager phaseManager;
    private ScoreboardManager scoreboardManager;

    public static ThreeTeamKingdomWar getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        teamManager = new TeamManager();
        beaconManager = new BeaconManager();
        phaseManager = new PhaseManager();
        scoreboardManager = new ScoreboardManager();

        getServer().getPluginManager().registerEvents(beaconManager, this);
        getServer().getPluginManager().registerEvents(teamManager, this);

        getCommand("teambeacon").setExecutor(new TeamBeaconCommand());
        getCommand("jointeam").setExecutor(new JoinTeamCommand());
        getCommand("phase").setExecutor(new PhaseCommand());
        getCommand("start").setExecutor(new StartCommand());

        getLogger().info("ThreeTeamKingdomWar enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ThreeTeamKingdomWar disabled.");
    }

    public TeamManager getTeamManager() {
        return teamManager;
    }

    public BeaconManager getBeaconManager() {
        return beaconManager;
    }

    public PhaseManager getPhaseManager() {
        return phaseManager;
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }
}
