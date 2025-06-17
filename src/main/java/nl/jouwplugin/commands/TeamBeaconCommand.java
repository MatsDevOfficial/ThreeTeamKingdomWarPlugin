package nl.jouwplugin.commands;

import nl.jouwplugin.managers.TeamManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeamBeaconCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 1 || !(sender instanceof Player player)) {
            sender.sendMessage("Usage: /teambeacon <red|blue|green>");
            return true;
        }

        try {
            TeamManager.TeamColor color = TeamManager.TeamColor.valueOf(args[0].toUpperCase());
            ItemStack beacon = new ItemStack(Material.BEACON);
            ItemMeta meta = beacon.getItemMeta();
            meta.setDisplayName(color.name() + " Team Beacon");
            beacon.setItemMeta(meta);
            player.getInventory().addItem(beacon);
            player.sendMessage(ChatColor.GREEN + color.name() + " beacon received.");
        } catch (IllegalArgumentException e) {
            sender.sendMessage(ChatColor.RED + "Invalid team color.");
        }
        return true;
    }
}
