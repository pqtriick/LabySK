package de.pqtriick.labysk.laby.laby4.display;

import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.entity.Player;

public class PlayingGamemode {

    public static void sendPlayingGamemode(Player player, String display) {
        LabyModPlayer labyPlayer = LabyModProtocolService.get().getPlayer(player.getUniqueId());
        labyPlayer.sendPlayingGameMode(display);
    }
}
