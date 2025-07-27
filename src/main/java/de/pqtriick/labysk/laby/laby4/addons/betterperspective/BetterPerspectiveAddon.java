package de.pqtriick.labysk.laby.laby4.addons.betterperspective;

import de.pqtriick.labysk.laby.laby4.player.LabyPlayer;
import net.labymod.serverapi.integration.betterperspective.BetterPerspectivePlayer;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import org.bukkit.entity.Player;

public class BetterPerspectiveAddon {

    public static void setCameraState(Player player, boolean allow) {
        LabyModPlayer labyModPlayer = LabyPlayer.getPlayer(player);
        if (labyModPlayer == null) return;
        BetterPerspectivePlayer betterPerspectivePlayer = labyModPlayer.getIntegrationPlayer(BetterPerspectivePlayer.class);
        if (betterPerspectivePlayer == null) return;
        if (allow) {
            betterPerspectivePlayer.allowUnlockCamera();
        } else {
            betterPerspectivePlayer.denyUnlockCamera();
        }
    }
}