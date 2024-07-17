package de.pqtriick.labysk.elements.conditions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.CheckForLaby;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;


public class CheckLabyPlayer extends Condition {

    Expression<Player> player;

    static {
        Skript.registerCondition(CheckLabyPlayer.class, "if %player% is using labymod");
    }

    @Override
    public boolean check(Event event) {
        Player labyPlayer = player.getSingle(event);
        return CheckForLaby.check(labyPlayer) == isNegated();
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
