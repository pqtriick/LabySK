package de.pqtriick.labysk.laby.laby4.display;

import de.pqtriick.labysk.laby.laby4.player.LabyPlayer;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.entity.Player;

public class PlayingGamemode {

    public static void sendPlayingGamemode(Player player, String display) {
        LabyModPlayer labyPlayer = LabyPlayer.getPlayer(player);
        if (labyPlayer == null) return;
        labyPlayer.sendPlayingGameMode(display);
    }
}
