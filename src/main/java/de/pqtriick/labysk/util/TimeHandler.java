package de.pqtriick.labysk.util;
import de.pqtriick.labysk.LabySK;
import de.pqtriick.labysk.laby.laby4.player.LabyVoice;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import java.util.function.Consumer;
public class TimeHandler {
    public static void handle() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(LabySK.getLabySK(), new Consumer<BukkitTask>() {
            @Override
            public void accept(BukkitTask bukkitTask) {
                for (Player player : LabyVoice.mutedPlayers.keySet()) {
                    long time = LabyVoice.mutedPlayers.get(player);
                    if (time >= 60000) {
                        time -= 60000;
                        LabyVoice.mutedPlayers.remove(player);
                        LabyVoice.mutedPlayers.put(player, time);
                    } else {
                        LabyVoice.unmute(player);
                    }
                }
            }
        }, 0, 60*20); //Every minute
    }
}