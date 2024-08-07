package de.pqtriick.labysk.elements.effects.subtitle;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.display.LabySubtitle;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Remove Subtitle of player")
@Description("Removes the subtitle of the player")
@Examples({"remove subtitle of player for player"})
public class RemoveSubtitleEff extends Effect {

    private Expression<Player> player;
    private Expression<Player> target;

    static {
        Skript.registerEffect(RemoveSubtitleEff.class, "remove subtitle of %player% for %player%");
    }

    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        Player t = target.getSingle(event);
        LabySubtitle.sendSubtitle(t, p, null, 0.8);

    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        target = (Expression<Player>) expressions[1];
        return true;
    }
}