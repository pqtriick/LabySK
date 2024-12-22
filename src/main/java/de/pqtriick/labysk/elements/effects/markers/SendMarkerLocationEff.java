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

public class SendMarkerLocationEff extends Effect {

    static {
        Skript.registerEffect(SendMarkerLocationEff.class, "send marker to %player% at location %integer%, %integer%, %integer%");
    }

    private Expression<Player> player;
    private Expression<Integer> xLoc;
    private Expression<Integer> yLoc;
    private Expression<Integer> zLoc;

    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        int x = xLoc.getSingle(event);
        int y = yLoc.getSingle(event);
        int z = zLoc.getSingle(event);

        LabyMarker.sendToPlayerSpecific(p,x,y,z);

    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        xLoc = (Expression<Integer>) expressions[1];
        yLoc = (Expression<Integer>) expressions[2];
        zLoc = (Expression<Integer>) expressions[3];
        return true;
    }
}