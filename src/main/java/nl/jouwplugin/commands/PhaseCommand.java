package nl.jouwplugin.commands;

import nl.jouwplugin.ThreeTeamKingdomWar;
import org.bukkit.ChatColor;
import org.bukkit.command.*;

public class PhaseCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /phase <create|delete|set> <name> [time]");
            return true;
        }

        var manager = ThreeTeamKingdomWar.getInstance().getPhaseManager();
        String sub = args[0];
        String name = args[1];

        switch (sub.toLowerCase()) {
            case "create":
                manager.createPhase(name);
                sender.sendMessage(ChatColor.GREEN + "Phase " + name + " created.");
                break;

            case "delete":
                manager.deletePhase(name);
                sender.sendMessage(ChatColor.GREEN + "Phase " + name + " deleted.");
                break;

            case "set":
                if (args.length < 3) {
                    sender.sendMessage(ChatColor.RED + "Usage: /phase set <name> <time_in_seconds>");
                    return true;
                }
                try {
                    int time = Integer.parseInt(args[2]);
                    manager.startPhase(name, time);
                    sender.sendMessage(ChatColor.GREEN + "Phase " + name + " started for " + time + " seconds.");
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + "Invalid time.");
                }
                break;

            default:
                sender.sendMessage(ChatColor.RED + "Unknown phase subcommand.");
                break;
        }
        return true;
    }
}
