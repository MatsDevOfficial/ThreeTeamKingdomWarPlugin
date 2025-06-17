package nl.jouwplugin.commands;

import nl.jouwplugin.managers.BeaconManager;
import nl.jouwplugin.managers.TeamColor;
import nl.jouwplugin.managers.TeamManager;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeamBeaconCommand implements CommandExecutor {

    private final BeaconManager beaconManager;
    private final TeamManager teamManager;

    public TeamBeaconCommand(BeaconManager beaconManager, TeamManager teamManager) {
        this.beaconManager = beaconManager;
        this.teamManager = teamManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage("Usage: /teambeacon <red|blue|green>");
            return true;
        }

        try {
            TeamColor teamColor = TeamColor.valueOf(args[0].toUpperCase());

            ItemStack beacon = new ItemStack(Material.BEACON);
            ItemMeta meta = beacon.getItemMeta();
            meta.setDisplayName(teamColor.name() + " Team Beacon");
            beacon.setItemMeta(meta);

            player.getInventory().addItem(beacon);
            player.sendMessage(teamColor.name() + " team beacon given!");
        } catch (IllegalArgumentException e) {
            player.sendMessage("Invalid team. Choose red, blue, or green.");
        }

        return true;
    }
}
