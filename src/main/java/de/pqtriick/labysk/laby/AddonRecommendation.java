package de.pqtriick.labysk.laby;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.pqtriick.labysk.LabySK;
import org.bukkit.entity.Player;

public class AddonRecommendation {

    public static void recommend(String addonid, Player player, boolean required) {
        JsonObject object = new JsonObject();
        JsonArray array = new JsonArray();
        JsonObject addon = new JsonObject();
        addon.addProperty("namespace", addonid);
        addon.addProperty("required", required);
        array.add(addon);
        object.add("addons", array);
        player.sendPluginMessage(LabySK.getLabySK(), "labymod3:main", Protocol.getBytesToSend("addon_recommendation", object.toString()));

    }
}
