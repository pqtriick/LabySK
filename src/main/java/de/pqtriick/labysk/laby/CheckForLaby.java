package de.pqtriick.labysk.laby;

import org.bukkit.entity.Player;
import java.util.ArrayList;

public class CheckForLaby {

    public static ArrayList<Player> labyPlayers = new ArrayList<>();

    public static boolean check(Player player) {
        return labyPlayers.contains(player);
    }



}
