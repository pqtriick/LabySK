package de.pqtriick.labysk.laby;

import com.google.gson.JsonObject;
import de.pqtriick.labysk.LabySK;
import org.bukkit.entity.Player;

public class ServerBanner {

    public static void sendBanner(Player player, String banner) {
        JsonObject object = new JsonObject();
        object.addProperty("url", banner);
        player.sendPluginMessage(LabySK.getLabySK(), "labymod3:main", Protocol.getBytesToSend("server_banner", object.toString()));
    }
}
