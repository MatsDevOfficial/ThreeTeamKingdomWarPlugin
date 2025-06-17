package nl.jouwplugin.managers;

import nl.jouwplugin.ThreeTeamKingdomWar;
import org.bukkit.scheduler.BukkitRunnable;

public class PhaseManager {

    private String currentPhase;
    private int timer;

    public void startPhase(String phaseName, int seconds) {
        this.currentPhase = phaseName;
        this.timer = seconds;

        new BukkitRunnable() {
            @Override
            public void run() {
                timer--;
                if (timer <= 0) {
                    cancel();
                    // Phase ended logic
                } else {
                    // Update scoreboard, etc
                    ThreeTeamKingdomWar.getInstance().getServer().getConsoleSender()
                            .sendMessage("Phase " + currentPhase + " time left: " + timer);
                }
            }
        }.runTaskTimer(ThreeTeamKingdomWar.getInstance(), 0L, 20L);
    }

    // andere methodes
}
