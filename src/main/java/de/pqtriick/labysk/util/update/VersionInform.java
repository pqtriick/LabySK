package de.pqtriick.labysk.util.update;

import de.pqtriick.labysk.LabySK;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VersionInform implements Listener {

    private String resourcelink = "§3https://www.spigotmc.org/resources/labysk.116590/";
    private String updatemsg =  "§3There is a new update Available for LabySK!";

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.isOp() && LabySK.hasUpdate) {
            player.sendMessage(LabySK.PREFIX + " §7| " + updatemsg);
            player.sendMessage(LabySK.PREFIX + " §7| " + resourcelink);
        }
    }
}
