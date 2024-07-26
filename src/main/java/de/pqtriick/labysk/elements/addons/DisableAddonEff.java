package de.pqtriick.labysk.elements.addons;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.addons.DisableAddons;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class DisableAddonEff extends Effect {

    private Expression<Player> player;

    static {
        Skript.registerEffect(DisableAddonEff.class, "disable added addons for %player%");
    }
    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        DisableAddons.send(p);

    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        return true;
    }
}
