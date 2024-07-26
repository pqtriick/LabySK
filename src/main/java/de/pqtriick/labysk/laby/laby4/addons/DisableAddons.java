package de.pqtriick.labysk.laby.laby4.addons;

import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
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
        LabyModPlayer labyPlayer = LabyModProtocolService.get().getPlayer(player.getUniqueId());
        labyPlayer.disableAddons(disabledAddons);
    }
}
