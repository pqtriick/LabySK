package de.pqtriick.labysk.elements.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import net.labymod.serverapi.server.bukkit.event.LabyModPlayerJoinEvent;
import org.bukkit.entity.Player;


public class LabyJoinEvent {

    static {
        Skript.registerEvent("Labymod Join Event", SimpleEvent.class, LabyModPlayerJoinEvent.class, "join with labymod");
        EventValues.registerEventValue(LabyModPlayerJoinEvent.class, Player.class, new Getter<Player, LabyModPlayerJoinEvent>() {
            @Override
            public Player get(LabyModPlayerJoinEvent labyModPlayerJoinEvent) {
                return labyModPlayerJoinEvent.labyModPlayer().getPlayer();
            }
        }, 0);
    }
}
