package de.pqtriick.labysk.laby.laby4;

import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.entity.Player;

public class CheckForLaby {


    public static boolean check(Player player) {
        LabyModPlayer labyPlayer = LabyModProtocolService.get().getPlayer(player.getUniqueId());
        return labyPlayer != null;
    }
}
