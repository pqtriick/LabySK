package de.pqtriick.labysk.util.update;

import ch.njol.skript.doc.Examples;
import de.pqtriick.labysk.LabySK;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VersionInform implements Listener {

    private Component resourcelink = Component.text("Click to view Resource!").color(TextColor.color(0xE43A96)).clickEvent(ClickEvent.openUrl("https://www.spigotmc.org/resources/labysk.116590/"));
    private Component updatemsg =  Component.text("There is a new update available!").color(TextColor.color(0xE43A96));

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.isOp() && LabySK.hasUpdate) {
            player.sendMessage(LabySK.PREFIX.append(Component.text(" §7| ").append(updatemsg)));
            player.sendMessage(LabySK.PREFIX.append(Component.text(" §7| ").append(resourcelink)));
        }
    }
}
