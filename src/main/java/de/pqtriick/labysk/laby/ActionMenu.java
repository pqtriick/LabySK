package de.pqtriick.labysk.laby;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class ActionMenu {


    private static HashMap<Player, JsonArray> actionMap = new HashMap<>();


    public static void sendActions(Player player) {
        Protocol.sendLabyModMessage(player, "user_menu_actions", actionMap.get(player));
    }

    public static void addAction(String name, String actionType, String value, Player player) {
        boolean exists = false;
        JsonObject object = new JsonObject();
        object.addProperty("displayName", name);
        object.addProperty("type", actionType);
        object.addProperty("value", value);
        if (!actionMap.containsKey(player)) {
            JsonArray array = new JsonArray();
            array.add(object);
            actionMap.put(player, array);
        } else {
            JsonArray array = actionMap.get(player);
            for (JsonElement element : array) {
                if (element.isJsonObject() && (!element.getAsJsonObject().equals(object))) {
                    exists = true;
                }
            }
            if (exists) {
                array.add(object);
                actionMap.remove(player);
                actionMap.put(player, array);
            }
        }
    }
    public static void removeFromMap(Player player) {
        actionMap.remove(player);
    }
}
