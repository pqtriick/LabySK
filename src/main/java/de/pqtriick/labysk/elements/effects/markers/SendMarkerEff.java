package de.pqtriick.labysk.elements.effects.markers;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.display.marker.LabyMarker;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class SendMarkerEff extends Effect {

    private Expression<Player> player;
    private Expression<String> type;

    static {
        Skript.registerEffect(SendMarkerEff.class, "set marker send type of %player% to %string%");
    }

    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        String t = type.getSingle(event);
        LabyMarker.sendToAll(p, t.toUpperCase());

    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        type = (Expression<String>) expressions[1];
        return true;
    }
}