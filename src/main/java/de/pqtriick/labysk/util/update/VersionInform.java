package de.pqtriick.labysk.util.update;

import de.pqtriick.labysk.LabySK;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VersionInform implements Listener {

    private String resourcelink = "§6https://www.spigotmc.org/resources/labysk.116590/";
    private String updatemsg = "§eThere is a new update available!";

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.isOp() && LabySK.hasUpdate) {
            player.sendMessage(LabySK.PREFIX + " " + updatemsg);
            player.sendMessage(LabySK.PREFIX + " " + resourcelink);
        }
    }
}
