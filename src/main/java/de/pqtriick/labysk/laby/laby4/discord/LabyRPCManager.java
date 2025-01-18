package de.pqtriick.labysk.laby.laby4.discord;

import de.pqtriick.labysk.laby.laby4.player.LabyPlayer;
import net.labymod.serverapi.core.model.feature.DiscordRPC;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import org.bukkit.entity.Player;


public class LabyRPCManager {


    public static void addDefaultPresence(Player player, String title) {
        DiscordRPC realRpc = DiscordRPC.create(title);
        sendRPC(player, realRpc);
    }

    public static void addPresenceEndTime(Player player, String title, int minutes) {
        Long endTime = System.currentTimeMillis() + minutes* 60000L;
        DiscordRPC realRpc = DiscordRPC.createWithEnd(title, endTime);
        sendRPC(player, realRpc);
    }

    public static void addPresenceWithTimer(Player player, String title) {
        DiscordRPC realRpc = DiscordRPC.createWithStart(title, System.currentTimeMillis());
        sendRPC(player, realRpc);

    }

    private static void sendRPC(Player player, DiscordRPC rpc) {
        LabyModPlayer labyPlayer = LabyPlayer.getPlayer(player);
        if (labyPlayer == null) return;
        labyPlayer.sendDiscordRPC(rpc);
    }

    public static void resetPresence(Player player) {
        DiscordRPC rpc = DiscordRPC.createReset();
        sendRPC(player, rpc);
    }


}