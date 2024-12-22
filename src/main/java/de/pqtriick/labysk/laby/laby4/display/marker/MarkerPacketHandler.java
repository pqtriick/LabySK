package de.pqtriick.labysk.laby.laby4.display.marker;

import net.labymod.serverapi.api.packet.PacketHandler;
import net.labymod.serverapi.core.LabyModProtocol;
import net.labymod.serverapi.core.packet.clientbound.game.feature.marker.AddMarkerPacket;
import net.labymod.serverapi.core.packet.serverbound.game.feature.marker.ClientAddMarkerPacket;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class MarkerPacketHandler implements PacketHandler<ClientAddMarkerPacket> {

    private final LabyModProtocolService protocolService;

    public MarkerPacketHandler(LabyModProtocolService protocolService) {
        this.protocolService = protocolService;
    }

    @Override
    public void handle(@NotNull UUID uuid, @NotNull ClientAddMarkerPacket clientAddMarkerPacket) {
        AddMarkerPacket packet = clientAddMarkerPacket.toAddMarkerPacket(uuid);
        LabyModProtocol protocol = this.protocolService.labyModProtocol();
        this.protocolService.forEachPlayer(p -> protocol.sendPacket(
                p.getUniqueId(), clientAddMarkerPacket
        ));
    }
}