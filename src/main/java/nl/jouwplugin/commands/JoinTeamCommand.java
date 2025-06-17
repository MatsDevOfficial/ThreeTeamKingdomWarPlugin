package nl.jouwplugin.commands;

import nl.jouwplugin.managers.TeamColor;
import nl.jouwplugin.managers.TeamManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinTeamCommand implements CommandExecutor {

    private final TeamManager teamManager;

    public JoinTeamCommand(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage("Usage: /jointeam <red|blue|green>");
            return true;
        }

        try {
            TeamColor teamColor = TeamColor.valueOf(args[0].toUpperCase());
            teamManager.addPlayerToTeam(player, teamColor);
            player.sendMessage("You joined the " + teamColor.name() + " team!");
        } catch (IllegalArgumentException e) {
            player.sendMessage("Invalid team. Choose red, blue, or green.");
        }

        return true;
    }
}
