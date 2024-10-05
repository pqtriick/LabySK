package de.pqtriick.labysk.laby.laby4.action;

import net.labymod.serverapi.api.model.component.ServerAPIComponent;
import net.labymod.serverapi.core.model.feature.InteractionMenuEntry;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LabyActions {

    private static HashMap<Player, List<InteractionMenuEntry>> actionmap = new HashMap<>();


    public static void sendActions(Player player) {
        LabyModPlayer labyPlayer = LabyModProtocolService.get().getPlayer(player.getUniqueId());
        if (labyPlayer == null) return;
        labyPlayer.sendInteractionMenuEntries(actionmap.get(player));
    }

    public static void addAction(String name, String type, String value, Player player) {
        InteractionMenuEntry.InteractionMenuType menuType = null;
        switch (type) {
            case "RUN_COMMAND" -> menuType = InteractionMenuEntry.InteractionMenuType.RUN_COMMAND;
            case "CLIPBOARD" -> menuType = InteractionMenuEntry.InteractionMenuType.CLIPBOARD;
            case "SUGGEST_COMMAND" -> menuType = InteractionMenuEntry.InteractionMenuType.SUGGEST_COMMAND;
            case "OPEN_BROWSER" -> menuType = InteractionMenuEntry.InteractionMenuType.OPEN_BROWSER;
        }
        InteractionMenuEntry entry = InteractionMenuEntry.create(
                ServerAPIComponent.text(name), menuType, value
        );
        if (actionmap.get(player) != null) {
            List<InteractionMenuEntry> list = actionmap.get(player);
            list.add(entry);
            actionmap.remove(player);
            actionmap.put(player, list);
        } else {
            List<InteractionMenuEntry> newlist = new ArrayList<>();
            newlist.add(entry);
            actionmap.put(player, newlist);
        }

    }

    public static void removeAction(String name, String type, String value, Player player) {
        InteractionMenuEntry.InteractionMenuType menuType = null;
        switch (type) {
            case "RUN_COMMAND" -> menuType = InteractionMenuEntry.InteractionMenuType.RUN_COMMAND;
            case "CLIPBOARD" -> menuType = InteractionMenuEntry.InteractionMenuType.CLIPBOARD;
            case "SUGGEST_COMMAND" -> menuType = InteractionMenuEntry.InteractionMenuType.SUGGEST_COMMAND;
            case "OPEN_BROWSER" -> menuType = InteractionMenuEntry.InteractionMenuType.OPEN_BROWSER;
        }
        InteractionMenuEntry entry = InteractionMenuEntry.create(
                ServerAPIComponent.text(name), menuType, value
        );
        if (actionmap.get(player) != null) {
            List<InteractionMenuEntry> list = actionmap.get(player);
            if (list.contains(entry)) {
                list.remove(entry);
            }
        }
    }

    public static void removeFromMap(Player player) {
        actionmap.remove(player);
    }
}
