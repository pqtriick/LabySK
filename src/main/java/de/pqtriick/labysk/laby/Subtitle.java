package de.pqtriick.labysk.laby;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.pqtriick.labysk.LabySK;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Subtitle {

    public static void sendSubtitle(Player reciever, UUID player, String text, double size) {
        JsonArray array = new JsonArray();
        JsonObject subtitle = new JsonObject();
        subtitle.addProperty("uuid", player.toString());
        subtitle.addProperty("size", size);
        if (text != null) {
            subtitle.addProperty("value", text);
        }
        array.add(subtitle);
        reciever.sendPluginMessage(LabySK.getLabySK(), "labymod3:main", Protocol.getBytesToSend("account_subtitle", array.toString()));



    }
}
