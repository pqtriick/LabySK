package de.pqtriick.labysk.laby;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.pqtriick.labysk.LabySK;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class LabyNPC {

    private static final List<Integer> VALID_EMOTES = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 11, 13, 14, 15, 18, 19, 20,
            22, 31, 32, 33, 34, 36, 37, 38, 40, 41, 43, 45, 46, 47, 49, 50, 51, 52, 53, 54, 55, 57, 59, 60, 61,
            62, 63, 69, 70, 74, 75, 76, 77, 78, 79, 83, 84, 85, 86, 89, 92, 93, 97, 98, 101, 105, 112, 113, 114,
            121, 122, 124, 126, 128, 130, 131, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 145, 146,
            148, 149, 150, 153, 154, 156, 157, 158, 159, 161, 162, 163, 164, 166, 167, 170, 171, 173, 178, 180,
            181, 182, 183, 184, 185, 187, 189, 191, 192, 193, 194, 195, 196, 197, 198, 200, 201, 202, 203, 204
    ));


    public static void createNPC(String name, Location location, String skin, int id) {
        Random random = new Random();
        UUID uuid = new UUID(random.nextLong(), 0);
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, uuid, id, skin);
        SkinTrait skinTrait = npc.getTrait(SkinTrait.class);
        skinTrait.setSkinName(skin);
        npc.setName(name);
        npc.spawn(location);
    }


    public static void playEmote(Player player, UUID npcUUID, int emote) {
        JsonArray array = new JsonArray();
        JsonObject object = new JsonObject();
        object.addProperty("uuid", npcUUID.toString());
        object.addProperty("emote_id", emote);
        array.add(object);
        player.sendPluginMessage(LabySK.getLabySK(), "labymod3:main", Protocol.getBytesToSend("emote_api", array.toString()));


    }

    public static void playRandomEmote(Player player, UUID npcUUID) {
        Random random = new Random();
        int emote = VALID_EMOTES.get(random.nextInt(VALID_EMOTES.size()));
        playEmote(player, npcUUID, emote);


    }

}
