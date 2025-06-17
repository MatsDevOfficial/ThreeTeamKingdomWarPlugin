package nl.jouwplugin.managers;

import nl.jouwplugin.ThreeTeamKingdomWar;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.*;

public class TeamManager implements Listener {

    public enum TeamColor { RED, BLUE, GREEN }

    private final Map<TeamColor, Set<Player>> teams = new HashMap<>();

    public TeamManager() {
        for (TeamColor color : TeamColor.values()) {
            teams.put(color, new HashSet<>());
        }
    }

    public void joinTeam(Player player, TeamColor color) {
        for (Set<Player> set : teams.values()) {
            set.remove(player);
        }
        if (teams.get(color).size() >= 30) {
            player.sendMessage(ChatColor.RED + "That team is full.");
            return;
        }
        teams.get(color).add(player);
        player.setPlayerListName(color.name() + " | " + player.getName());
        player.sendMessage(ChatColor.GREEN + "Joined " + color.name() + " team!");
    }

    public Map<TeamColor, Set<Player>> getTeams() {
        return teams;
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        for (Map.Entry<TeamColor, Set<Player>> entry : teams.entrySet()) {
            if (entry.getValue().contains(player)) {
                var beaconLoc = ThreeTeamKingdomWar.getInstance().getBeaconManager().getBeacon(entry.getKey());
                if (beaconLoc != null && beaconLoc.getBlock().getType().isBlock()) {
                    event.setRespawnLocation(beaconLoc.add(0.5, 1, 0.5));
                } else {
                    player.sendMessage(ChatColor.RED + "Your beacon is destroyed — you cannot respawn.");
                }
                break;
            }
        }
    }
}
