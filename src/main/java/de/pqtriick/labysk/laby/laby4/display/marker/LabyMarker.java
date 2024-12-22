package de.pqtriick.labysk.laby.laby4.display.marker;

import net.labymod.serverapi.core.LabyModProtocol;
import net.labymod.serverapi.core.packet.clientbound.game.feature.marker.AddMarkerPacket;
import net.labymod.serverapi.core.packet.clientbound.game.feature.marker.MarkerPacket;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.entity.Player;

public class LabyMarker {

    public static void sendToAll(Player player, String type) {
        LabyModProtocol protocol = LabyModProtocolService.get().labyModProtocol();
        switch (type) {
            case "BLOCKED":
                protocol.sendPacket(player.getUniqueId(), new MarkerPacket(MarkerPacket.MarkerSendType.SERVER));
                break;
            case "FRIENDS":
                protocol.sendPacket(player.getUniqueId(), new MarkerPacket(MarkerPacket.MarkerSendType.LABY_CONNECT));
                break;
        }
    }

    public static void sendToPlayerSpecific(Player player, int x, int y, int z) {
        LabyModProtocol protocol = LabyModProtocolService.get().labyModProtocol();
        protocol.sendPacket(player.getUniqueId(), new AddMarkerPacket(
                player.getUniqueId(), x, y, z, true, null));
    }
}
