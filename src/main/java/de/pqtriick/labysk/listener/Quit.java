package de.pqtriick.labysk.listener;

import de.pqtriick.labysk.laby.ActionMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        ActionMenu.removeFromMap(event.getPlayer());
    }
}
