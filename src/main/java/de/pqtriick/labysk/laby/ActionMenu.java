package de.pqtriick.labysk.laby;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.pqtriick.labysk.LabySK;
import it.unimi.dsi.fastutil.Hash;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ActionMenu {


    private static HashMap<Player, JsonArray> actionMap = new HashMap<>();

    public static void sendActions(Player player) {
        player.sendPluginMessage(LabySK.getLabySK(),"labymod3:main", Protocol.getBytesToSend("user_menu_actions", actionMap.get(player).toString()));
    }

    public static void addAction(String name, String actionType, String value, Player player) {
        JsonObject object = new JsonObject();
        object.addProperty("displayName", name);
        object.addProperty("type", actionType);
        object.addProperty("value", value);
        if(!actionMap.containsKey(player)) {
            JsonArray array = new JsonArray();
            array.add(object);
            actionMap.put(player, array);
        } else {
            JsonArray array = actionMap.get(player);
            if (!array.contains(object)) {
                array.add(object);
                actionMap.remove(player);
                actionMap.put(player, array);
            }
        }
    }

    public static void removeAction(String name, String actionType, String value, Player player) {
        JsonObject object = new JsonObject();
        object.addProperty("displayName", name);
        object.addProperty("type", actionType);
        object.addProperty("value", value);
        if(actionMap.containsKey(player)) {
            JsonArray array = actionMap.get(player);
            if (array.contains(object)) {
                array.remove(object);
                actionMap.remove(player);
                actionMap.put(player, array);
            }
        }
    }

    public static void removeFromMap(Player player) {
        actionMap.remove(player);
    }

}



