package de.pqtriick.labysk.laby.laby4.player;

import net.labymod.serverapi.api.model.component.ServerAPIComponent;
import net.labymod.serverapi.core.model.supplement.ServerSwitchPrompt;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.entity.Player;

public class SendToServer {


    public static void send(Player player, String ip, String title) {

        ServerSwitchPrompt serverSwitchPrompt = ServerSwitchPrompt.create(
                ServerAPIComponent.text(title), ip);

        LabyModPlayer labyPlayer = LabyModProtocolService.get().getPlayer(player.getUniqueId());
        labyPlayer.openServerSwitchPrompt(serverSwitchPrompt);
    }
}
