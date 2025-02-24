package de.pqtriick.labysk.laby.laby4.player;

import net.labymod.serverapi.integration.voicechat.VoiceChatPlayer;
import net.labymod.serverapi.integration.voicechat.model.VoiceChatMute;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class LabyVoice {

    public static HashMap<Player, Long> mutedPlayers = new HashMap<>();
    public static HashMap<Player, String> muteReason = new HashMap<>();

    public static void mute(Player player, String reason, int minutes) {
        long time = minutes*60000L;
        VoiceChatMute mute = VoiceChatMute.create(player.getUniqueId(), reason, System.currentTimeMillis() + time);
        LabyModPlayer labyPlayer = LabyPlayer.getPlayer(player);
        if (labyPlayer == null) return;
        VoiceChatPlayer voiceplayer = labyPlayer.getIntegrationPlayer(VoiceChatPlayer.class);
        voiceplayer.mute(mute);
        mutedPlayers.put(player, time);
        muteReason.put(player, reason);
    }

    public static void unmute(Player player) {
        LabyModPlayer labyPlayer = LabyPlayer.getPlayer(player);
        if (labyPlayer == null) return;
        VoiceChatPlayer voiceplayer = labyPlayer.getIntegrationPlayer(VoiceChatPlayer.class);
        voiceplayer.unmute();
        mutedPlayers.remove(player);
        muteReason.remove(player);
    }
}
