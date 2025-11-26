package de.pqtriick.labysk.elements.effects.badges;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.display.LabyBadge;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class SetBadgeEff extends Effect {

    private int pattern;
    private Expression<Player> player;
    private boolean enable;

    static {
        Skript.registerEffect(SetBadgeEff.class, "(1:(enable)|2:(disable)) badges for %player%");
    }

    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        switch (pattern) {
            case 1:
                enable = true;
            case 2:
                enable = false;
        }

        LabyBadge.setIndicatorStatus(p, enable);
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        pattern = parseResult.mark;
        player = (Expression<Player>) expressions[0];
        return true;
    }
}