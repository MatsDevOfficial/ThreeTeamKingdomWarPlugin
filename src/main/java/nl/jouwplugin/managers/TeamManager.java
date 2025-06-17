package nl.jouwplugin.managers;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TeamManager {

    private final Map<Player, TeamColor> playerTeams = new HashMap<>();

    public void addPlayerToTeam(Player player, TeamColor team) {
        playerTeams.put(player, team);
    }

    public void removePlayerFromTeam(Player player) {
        playerTeams.remove(player);
    }

    public TeamColor getTeam(Player player) {
        return playerTeams.get(player);
    }

    public boolean isInTeam(Player player) {
        return playerTeams.containsKey(player);
    }

    public Set<TeamColor> getTeams() {
        return playerTeams.values().stream().collect(Collectors.toSet());
    }
}
