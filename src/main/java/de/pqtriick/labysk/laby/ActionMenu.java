package de.pqtriick.labysk.laby;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.bukkit.entity.Player;

public class ActionMenu {

    private static JsonArray array = new JsonArray();

    public static void sendActions(Player player) {
        Protocol.sendLabyModMessage(player, "user_menu_actions", array);
    }

    public static void addAction(String name, String actionType, String value) {
        JsonObject object = new JsonObject();
        object.addProperty("displayName", name);
        object.addProperty("type", actionType);
        object.addProperty("value", value);
        for (int i = 0; i < array.size(); i++) {
            if (!array.get(i).equals(object)) {
                array.add(object);
            }
        }
    }



}
