package de.pqtriick.labysk.laby.laby4.inputprompt;

import net.labymod.serverapi.api.model.component.ServerAPIComponent;
import net.labymod.serverapi.api.model.component.ServerAPITextColor;
import net.labymod.serverapi.api.model.component.ServerAPITextDecoration;
import net.labymod.serverapi.core.model.supplement.InputPrompt;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class LabyInputPrompt {

    public static HashMap<String, InputPrompt> createdImputs = new HashMap<>();
    public static HashMap<Player, String> input = new HashMap<>();

    public static void createPrompt(String id,String text, ServerAPITextColor color, ServerAPITextDecoration deco, String placeholder, String defaultValue, int maxLength) {
        InputPrompt prompt;
        if (deco == null) {
            prompt = InputPrompt.builder().title(ServerAPIComponent.text(text)
                            .color(color))
                    .placeholder(ServerAPIComponent.text(placeholder))
                    .defaultValue(defaultValue)
                    .maxLength(maxLength).build();
        } else {
            prompt = InputPrompt.builder().title(ServerAPIComponent.text(text)
                            .color(color)
                            .decorate(deco))
                    .placeholder(ServerAPIComponent.text(placeholder))
                    .defaultValue(defaultValue)
                    .maxLength(maxLength).build();
        }
        createdImputs.put(id, prompt);
    }

    public static void sendPrompt(String id, Player player) {
        LabyModPlayer labyPlayer = LabyModProtocolService.get().getPlayer(player.getUniqueId());
        if (labyPlayer == null) return;
        labyPlayer.openInputPrompt(createdImputs.get(id), val -> {
            input.put(player, val);
        });
    }

    public static String getInput(Player player) {
        String s = input.get(player);
        System.out.println(s);
        return s;
    }
}
