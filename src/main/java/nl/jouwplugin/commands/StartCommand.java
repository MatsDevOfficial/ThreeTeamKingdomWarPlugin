package nl.jouwplugin.commands;

import nl.jouwplugin.ThreeTeamKingdomWar;
import nl.jouwplugin.managers.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        var teamManager = ThreeTeamKingdomWar.getInstance().getTeamManager();
        var beaconManager = ThreeTeamKingdomWar.getInstance().getBeaconManager();

        for (var entry : teamManager.getTeams().entrySet()) {
            TeamManager.TeamColor color = entry.getKey();
            Location beaconLoc = beaconManager.getBeacon(color);

            if (beaconLoc == null) {
                sender.sendMessage(ChatColor.RED + "Beacon for " + color.name() + " team is missing!");
                return true;
            }

            for (Player player : entry.getValue()) {
                player.teleport(beaconLoc.clone().add(0.5, 1, 0.5));
                player.sendMessage(ChatColor.GOLD + "You have been teleported to your team's beacon.");
            }
        }

        Bukkit.broadcastMessage(ChatColor.AQUA + "The game has started!");
        return true;
    }
}
