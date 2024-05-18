package de.pqtriick.labysk.elements.effects.tablist;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.CountryCode;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class CountryTabEff extends Effect {

    private Expression<Player> player;
    private Expression<Player> reciever;

    static {
        Skript.registerEffect(CountryTabEff.class, "send country flag from %player% to %player%");
    }
    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        Player r = reciever.getSingle(event);
        CountryCode.sendFlag(r, p.getUniqueId(), CountryCode.getCountryCode(p));

    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        reciever = (Expression<Player>) expressions[1];
        return true;
    }
}
