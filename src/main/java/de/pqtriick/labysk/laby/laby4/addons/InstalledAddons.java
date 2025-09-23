package de.pqtriick.labysk.laby.laby4.addons;

import net.labymod.serverapi.core.model.moderation.InstalledAddon;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;

import java.util.*;

public class InstalledAddons {

    public static HashMap<UUID, List<String>> installedAddons = new HashMap<>();

    private static Collection<InstalledAddon> addons;

    public static void getInstalledAddons(LabyModPlayer player) {
        List<String> addonNamespaces = new ArrayList<>();
        player.requestInstalledAddons(response -> {
           addons = response.getInstalledAddons();
            for (InstalledAddon addon : addons) {
                String s = addon.getNamespace() + " : " + addon.getVersion();
                addonNamespaces.add(s);
            }
            installedAddons.put(player.getUniqueId(), addonNamespaces);
        });
    }
}
