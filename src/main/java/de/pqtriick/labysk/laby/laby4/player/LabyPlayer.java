package de.pqtriick.labysk.laby.laby4.player;

import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.entity.Player;

public class LabyPlayer {

    public static LabyModPlayer getPlayer(Player player) {
        LabyModPlayer labyModPlayer;
        try {
            labyModPlayer = LabyModProtocolService.get().getPlayer(player.getUniqueId());
        } catch (Exception e) {
            labyModPlayer = null;
        }
        return labyModPlayer;
    }
}
