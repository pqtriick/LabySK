package de.pqtriick.labysk.laby.laby4.display;

import net.labymod.serverapi.api.model.component.ServerAPIComponent;
import net.labymod.serverapi.core.LabyModProtocol;
import net.labymod.serverapi.core.packet.clientbound.game.display.SubtitlePacket;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class LabySubtitle {

    public static void sendSubtitle(Player reciever, Player player, String text, double size) {
        if (text != null) {
            List<net.labymod.serverapi.core.model.display.Subtitle> subtitles = new ArrayList<>();
            net.labymod.serverapi.core.model.display.Subtitle subtitle = net.labymod.serverapi.core.model.display.Subtitle.create(player.getUniqueId(), ServerAPIComponent.text(text), size);
            subtitles.add(subtitle);
            LabyModProtocol protocol = LabyModProtocolService.get().labyModProtocol();
            protocol.sendPacket(reciever.getUniqueId(), new SubtitlePacket(subtitles));
        } else {
            List<net.labymod.serverapi.core.model.display.Subtitle> subtitles = new ArrayList<>();
            net.labymod.serverapi.core.model.display.Subtitle subtitle = net.labymod.serverapi.core.model.display.Subtitle.create(player.getUniqueId(), (ServerAPIComponent) null, size);
            subtitles.add(subtitle);
            LabyModProtocol protocol = LabyModProtocolService.get().labyModProtocol();
            protocol.sendPacket(reciever.getUniqueId(), new SubtitlePacket(subtitles));
        }

    }
}
