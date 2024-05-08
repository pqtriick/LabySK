package de.pqtriick.labysk.laby;

import com.google.gson.JsonObject;
import de.pqtriick.labysk.LabySK;
import org.bukkit.entity.Player;

public class SendToServer {

    public static void sendPlayer(Player player, String title, String address, boolean preview) {
        JsonObject object = new JsonObject();
        object.addProperty("title", title);
        object.addProperty("address", address);
        object.addProperty("preview", preview);
        Protocol.sendLabyModMessage(player, "server_switch", object);
    }
}
