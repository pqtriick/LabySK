package de.pqtriick.labysk.laby.laby4.player;

import net.labymod.serverapi.api.AbstractProtocolService;
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

    public static boolean check(Player player) {
        LabyModPlayer labyPlayer = getPlayer(player);
        return labyPlayer != null;
    }
}
