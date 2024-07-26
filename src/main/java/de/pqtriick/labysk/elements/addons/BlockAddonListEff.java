package de.pqtriick.labysk.elements.addons;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.addons.DisableAddons;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class BlockAddonListEff extends Effect {

    private Expression<String> addon;

    static {
        Skript.registerEffect(BlockAddonListEff.class, "add addon with id %string% to blocked list");
    }

    @Override
    protected void execute(Event event) {
        String a = addon.getSingle(event);
        DisableAddons.add(a);

    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        addon = (Expression<String>) expressions[0];
        return true;
    }
}
