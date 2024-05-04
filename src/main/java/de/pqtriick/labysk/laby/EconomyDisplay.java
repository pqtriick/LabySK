package de.pqtriick.labysk.laby;

import com.google.gson.JsonObject;
import de.pqtriick.labysk.LabySK;
import org.bukkit.entity.Player;

public class EconomyDisplay {

    public static void setBalanceDisplay(Player player, int cash, int bank) {
        JsonObject object = new JsonObject();
        JsonObject cashObj = new JsonObject();
        JsonObject bankObj = new JsonObject();

        cashObj.addProperty("visible", true);
        bankObj.addProperty("visible", true);
        cashObj.addProperty("balance", cash);
        bankObj.addProperty("balance", bank);
        object.add("cash", cashObj);
        object.add("bank", bankObj);
        player.sendPluginMessage(LabySK.getLabySK(), "labymod3:main", Protocol.getBytesToSend("economy", object.toString()));

    }
}
