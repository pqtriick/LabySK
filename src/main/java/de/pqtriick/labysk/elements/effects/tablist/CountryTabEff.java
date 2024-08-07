package de.pqtriick.labysk.elements.effects.tablist;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.tablist.LabyTab;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class CountryTabEff extends Effect {

    private Expression<Player> player;

    static {
        Skript.registerEffect(CountryTabEff.class, "send country flag from %player%");
    }
    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        LabyTab.sendFlag(p);

    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        return true;
    }
}
