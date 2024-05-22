package de.pqtriick.labysk.laby;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.pqtriick.labysk.LabySK;
import org.bukkit.entity.Player;

public class ActionMenu {

    private static JsonArray array = new JsonArray();

    public static void sendActions(Player player) {
        player.sendPluginMessage(LabySK.getLabySK(),"labymod3:main", Protocol.getBytesToSend("user_menu_actions", array.toString()));
    }

    public static void addAction(String name, String actionType, String value) {
        JsonObject object = new JsonObject();
        object.addProperty("displayName", name);
        object.addProperty("type", actionType);
        object.addProperty("value", value);
        array.add(object);
    }

    public static void removeAction(String name, String actionType, String value) {
        JsonObject object = new JsonObject();
        object.addProperty("displayName", name);
        object.addProperty("type", actionType);
        object.addProperty("value", value);
        array.remove(object);
    }

}



