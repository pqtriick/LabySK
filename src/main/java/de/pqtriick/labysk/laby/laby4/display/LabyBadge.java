package de.pqtriick.labysk.laby.laby4.display;

import de.pqtriick.labysk.laby.laby4.player.LabyPlayer;
import net.labymod.serverapi.core.model.display.ServerBadge;
import net.labymod.serverapi.core.model.display.ServerUserBadge;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LabyBadge {

    private static HashMap<Integer, ServerBadge> badges = new HashMap<>();

    public static void createNewBadge(int id, String hexColor, String imageUrl) {
        ServerBadge badge = ServerBadge.create(id, Color.decode(hexColor), imageUrl);
        badges.put(id, badge);
    }

    public static void sendBadgeToPlayer(Player player, int badgeId) {
        LabyModPlayer labyModPlayer = LabyPlayer.getPlayer(player);
        if (labyModPlayer == null) return;
        ArrayList<ServerBadge> badgeList = new ArrayList<>();
        badgeList.add(badges.get(badgeId));
        labyModPlayer.registerBadges(badgeList);
        ServerUserBadge userBadge = ServerUserBadge.create(player.getUniqueId(), badgeId);
        ArrayList<ServerUserBadge> serverUserBadges = new ArrayList<>();
        serverUserBadges.add(userBadge);
        labyModPlayer.bindBadges(serverUserBadges);
    }

    public static void setIndicatorStatus(Player player, boolean b) {
        LabyModPlayer labyModPlayer = LabyPlayer.getPlayer(player);
        if (labyModPlayer == null) return;
        labyModPlayer.updateLabyModUserIndicatorVisibility(b);
    }
}