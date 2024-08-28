package de.pqtriick.labysk.laby.laby4.addons;

import de.pqtriick.labysk.laby.laby4.player.LabyPlayer;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class DisableAddons {

    public static List<String> disabledAddons = new ArrayList<>();

    public static void add(String name) {
        if (disabledAddons.contains(name)) return;
        disabledAddons.add(name);
    }

    public static void send(Player player) {
        LabyModPlayer labyPlayer = LabyPlayer.getPlayer(player);
        if (labyPlayer == null) return;
        labyPlayer.disableAddons(disabledAddons);
    }
}
