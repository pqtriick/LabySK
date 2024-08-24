package de.pqtriick.labysk.laby.laby4.player;

import net.labymod.serverapi.integration.voicechat.VoiceChatPlayer;
import net.labymod.serverapi.integration.voicechat.model.VoiceChatMute;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.entity.Player;

public class LabyVoice {

    public static void mute(Player player, String reason, int minutes) {
        long time = minutes*60000L;
        VoiceChatMute mute = VoiceChatMute.create(player.getUniqueId(), reason, System.currentTimeMillis() + time);
        LabyModPlayer labyplayer = LabyModProtocolService.get().getPlayer(player.getUniqueId());
        VoiceChatPlayer voiceplayer = labyplayer.getIntegrationPlayer(VoiceChatPlayer.class);
        if(!voiceplayer.isMuted()) {
            voiceplayer.mute(mute);
        }
    }

    public static void unmute(Player player) {
        LabyModPlayer labyplayer = LabyModProtocolService.get().getPlayer(player.getUniqueId());
        VoiceChatPlayer voiceplayer = labyplayer.getIntegrationPlayer(VoiceChatPlayer.class);
        if (voiceplayer.isMuted()) {
            voiceplayer.unmute();
        }
    }
}