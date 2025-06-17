package nl.jouwplugin.managers;

import nl.jouwplugin.ThreeTeamKingdomWar;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.LinkedHashMap;
import java.util.Map;

public class PhaseManager {

    public static class Phase {
        public String name;
        public int seconds;

        public Phase(String name, int seconds) {
            this.name = name;
            this.seconds = seconds;
        }
    }

    private final Map<String, Phase> phases = new LinkedHashMap<>();
    private Phase currentPhase;

    public void createPhase(String name) {
        phases.put(name, new Phase(name, 0));
    }

    public void deletePhase(String name) {
        phases.remove(name);
    }

    public void startPhase(String name, int time) {
        Phase phase = phases.get(name);
        if (phase != null) {
            phase.seconds = time;
            currentPhase = phase;
            startCountdown();
        }
    }

    private void startCountdown() {
        if (currentPhase == null) return;
        Bukkit.getScheduler().runTaskTimer(ThreeTeamKingdomWar.getInstance(), new Runnable() {
            int timeLeft = currentPhase.seconds;

            @Override
            public void run() {
                if (timeLeft <= 0) {
                    Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "Phase " + currentPhase.name + " ended.");
                    currentPhase = null;
                    Bukkit.getScheduler().cancelTasks(ThreeTeamKingdomWar.getInstance());
                    return;
                }
                Bukkit.getOnlinePlayers().forEach(p ->
                        p.sendActionBar(ChatColor.YELLOW + "Phase: " + currentPhase.name + " | " + timeLeft + "s"));
                timeLeft--;
            }
        }, 0L, 20L);
    }
}
