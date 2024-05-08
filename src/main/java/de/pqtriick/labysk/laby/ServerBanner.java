package de.pqtriick.labysk.laby;

import com.google.gson.JsonObject;
import de.pqtriick.labysk.LabySK;
import org.bukkit.entity.Player;

public class ServerBanner {

    public static void sendBanner(Player player, String banner) {
        JsonObject object = new JsonObject();
        object.addProperty("url", banner);
        Protocol.sendLabyModMessage(player, "server_banner", object);
    }
}
