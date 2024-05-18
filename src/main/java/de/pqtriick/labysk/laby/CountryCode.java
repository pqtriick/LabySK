package de.pqtriick.labysk.laby;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.pqtriick.labysk.LabySK;
import org.bukkit.entity.Player;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

public class CountryCode {

    public static void sendFlag(Player reciever, UUID uuid, String country) {
        JsonObject object = new JsonObject();
        JsonArray users = new JsonArray();
        JsonObject userObject = new JsonObject();
        userObject.addProperty("uuid", uuid.toString());
        userObject.addProperty("code", country);
        users.add(userObject);

        object.add("users",  users);

        reciever.sendPluginMessage(LabySK.getLabySK(),"labymod3:main", Protocol.getBytesToSend("language_flag", object.toString()));

    }

    public static String getCountryCode(Player player) {
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
            countryCode = countryCode.toLowerCase();
        } catch (Exception e) {}
        System.out.println("COUNTRY CODE SUCCESS | " + countryCode + " | " + ip);
        return countryCode;
    }

}
