package nl.jouwplugin.commands;

import nl.jouwplugin.managers.TeamColor;
import nl.jouwplugin.managers.TeamManager;
import nl.jouwplugin.managers.BeaconManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartCommand implements CommandExecutor {

    private final TeamManager teamManager;
    private final BeaconManager beaconManager;

    public StartCommand(TeamManager teamManager, BeaconManager beaconManager) {
        this.teamManager = teamManager;
        this.beaconManager = beaconManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("Usage: /start");
            return true;
        }

        // Voorbeeld waar TeamColor als String moet:
        for (TeamColor teamColor : teamManager.getTeams()) {
            // Gebruik .name() om TeamColor naar String te converteren
            String teamName = teamColor.name();

            // voorbeeld: teleport players, start game logic etc
            sender.sendMessage("Starting for team: " + teamName);
        }

        // Jouw start logica hier...

        return true;
    }
}
