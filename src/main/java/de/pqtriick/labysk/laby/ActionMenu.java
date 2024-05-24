package de.pqtriick.labysk.laby;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ActionMenu {


    private static HashMap<Player, JsonArray> actionMap = new HashMap<>();


    public static void sendActions(Player player) {
        Protocol.sendLabyModMessage(player, "user_menu_actions", actionMap.get(player));
    }

    public static void addAction(String name, String actionType, String value, Player player) {
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
            for (int i = 0; i < array.size(); i++) {
                if (!array.get(i).equals(object)) {
                    array.add(object);
                    actionMap.remove(player);
                    actionMap.put(player, array);
                }
            }
        }
    }
    public static void removeFromMap(Player player) {
        actionMap.remove(player);
    }
}
