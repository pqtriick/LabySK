package de.pqtriick.labysk.laby.laby4.player;

import net.labymod.serverapi.core.model.moderation.Permission;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

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

    public static String getLabyVersion(LabyModPlayer player) {
        return player.getLabyModVersion();
    }

    public static void sendPermission(LabyModPlayer player, boolean allowed) {
        List<Permission.StatedPermission> permissions = new ArrayList<>();
        if (allowed) {
            permissions.add(Permission.CHAT_AUTOTEXT.allow());
        } else {
            permissions.add(Permission.CHAT_AUTOTEXT.deny());
        }
        player.sendPermissions(permissions);
    }

}
