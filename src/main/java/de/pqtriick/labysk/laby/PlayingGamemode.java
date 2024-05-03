package de.pqtriick.labysk.laby;

import com.google.gson.JsonObject;
import de.pqtriick.labysk.LabySK;
import org.bukkit.entity.Player;

public class PlayingGamemode {

    public static void sendGamemode(Player player, boolean visible, String text) {
        JsonObject object = new JsonObject();
        object.addProperty("show_gamemode", visible);
        object.addProperty("gamemode_name", text);
        player.sendPluginMessage(LabySK.getLabySK(), "labymod3:main", Protocol.getBytesToSend("server_gamemode", object.toString()));
    }
}
