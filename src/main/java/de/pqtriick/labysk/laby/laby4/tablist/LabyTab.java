package de.pqtriick.labysk.laby.laby4.tablist;

import net.labymod.serverapi.core.model.display.TabListFlag;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.entity.Player;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LabyTab {

    public static void sendServerBanner(Player player, String banner) {
        LabyModPlayer labyPlayer = LabyModProtocolService.get().getPlayer(player.getUniqueId());
        labyPlayer.sendTabListBanner(banner);

    }

    public static void sendFlag(Player player) {
        LabyModPlayer labyPlayer = LabyModProtocolService.get().getPlayer(player.getUniqueId());
        String country = getCountryCode(player);
        labyPlayer.setTabListFlag(TabListFlag.TabListFlagCountryCode.getCountryCode(country));
    }

    private static String getCountryCode(Player player) {
        String ip = player.getAddress().toString();
        String countryCode = "";
        try {
            URL url = new URL("http://ip-api.com/json/" + ip + "fields=countryCode");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            BufferedReader br  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String readline;
            while ((readline = br.readLine()) != null) {
                countryCode = readline;
            }
            countryCode = countryCode.replace("{\"countryCode\":\"", "");
            countryCode = countryCode.replace("\"}", "");
            countryCode = countryCode.toUpperCase();
        } catch (Exception e) {}
        return countryCode;
    }

}
