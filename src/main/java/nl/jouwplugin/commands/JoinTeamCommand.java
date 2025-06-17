package nl.jouwplugin.commands;

import nl.jouwplugin.ThreeTeamKingdomWar;
import nl.jouwplugin.managers.TeamManager;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class JoinTeamCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 1 || !(sender instanceof Player player)) {
            sender.sendMessage("Usage: /jointeam <red|blue|green>");
            return true;
        }

        try {
            TeamManager.TeamColor color = TeamManager.TeamColor.valueOf(args[0].toUpperCase());
            ThreeTeamKingdomWar.getInstance().getTeamManager().joinTeam(player, color);
        } catch (IllegalArgumentException e) {
            sender.sendMessage("Invalid team color.");
        }
        return true;
    }
}
