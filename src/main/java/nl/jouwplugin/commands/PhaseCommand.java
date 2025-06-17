package nl.jouwplugin.commands;

import nl.jouwplugin.ThreeTeamKingdomWar;
import nl.jouwplugin.managers.PhaseManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PhaseCommand implements CommandExecutor {

    private final PhaseManager phaseManager;

    public PhaseCommand() {
        this.phaseManager = new PhaseManager();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage("Usage: /phase <create|delete|set|queue> ...");
            return true;
        }

        String sub = args[0];

        if (sub.equalsIgnoreCase("create") && args.length == 2) {
            String name = args[1];
            // Logic to create phase
            sender.sendMessage("Phase " + name + " created.");
        } else if (sub.equalsIgnoreCase("set") && args.length == 3) {
            String name = args[1];
            int time;
            try {
                time = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                sender.sendMessage("Time must be a number.");
                return true;
            }
            phaseManager.startPhase(name, time);
            sender.sendMessage("Phase " + name + " started for " + time + " seconds.");
        } else {
            sender.sendMessage("Invalid command usage.");
        }

        return true;
    }
}
