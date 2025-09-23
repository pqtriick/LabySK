package de.pqtriick.labysk.listener;

import de.pqtriick.labysk.laby.laby4.action.LabyActions;
import de.pqtriick.labysk.laby.laby4.addons.InstalledAddons;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import net.labymod.serverapi.server.bukkit.event.LabyModPlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        LabyActions.removeFromMap(event.getPlayer());
    }

    @EventHandler
    public void onJoin(LabyModPlayerJoinEvent event) {
        LabyModPlayer player = event.labyModPlayer();
        InstalledAddons.getInstalledAddons(player);
    }
}
