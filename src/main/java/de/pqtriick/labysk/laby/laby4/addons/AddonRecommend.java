package de.pqtriick.labysk.laby.laby4.addons;

import de.pqtriick.labysk.laby.laby4.player.LabyPlayer;
import net.labymod.serverapi.core.model.moderation.RecommendedAddon;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class AddonRecommend {

    public static void sendRecommendation(String namespace, Player player, boolean rqd) {
        LabyModPlayer labyPlayer = LabyPlayer.getPlayer(player);
        if (labyPlayer == null) return;
        RecommendedAddon addon = RecommendedAddon.of(namespace);
        List<RecommendedAddon> addons = new ArrayList<>();
        if (rqd) {
            addon.require();
        }
        addons.add(addon);

        labyPlayer.sendAddonRecommendations(addons);
    }

}
