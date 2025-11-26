package de.pqtriick.labysk.elements.effects.badges;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.display.LabyBadge;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class SendBadgeEff extends Effect {

    private Expression<Integer> id;
    private Expression<Player> player;

    static {
        Skript.registerEffect(SendBadgeEff.class, "send server badge with id %integer% to %player%");
    }


    @Override
    protected void execute(Event event) {
        int i = id.getSingle(event);
        Player p = player.getSingle(event);

        LabyBadge.sendBadgeToPlayer(p, i);

    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        id = (Expression<Integer>) expressions[0];
        player = (Expression<Player>) expressions[1];
        return true;
    }
}