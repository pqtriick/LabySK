package de.pqtriick.labysk.elements.conditions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.player.LabyPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;


public class CheckLabyPlayer extends Condition {

    Expression<Player> player;

    static {
        Skript.registerCondition(CheckLabyPlayer.class, "if %player% (1¦is|2¦is(n't| not)) using labymod");


    }

    @Override
    public boolean check(Event event) {
        Player labyPlayer = player.getSingle(event);
        if (labyPlayer == null) return isNegated();
        return LabyPlayer.check(labyPlayer) ? isNegated() : !isNegated();
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        setNegated(parseResult.mark == 1);
        return true;
    }
}
