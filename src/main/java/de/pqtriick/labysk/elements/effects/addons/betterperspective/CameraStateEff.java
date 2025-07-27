package de.pqtriick.labysk.elements.effects.addons.betterperspective;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.addons.betterperspective.BetterPerspectiveAddon;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class CameraStateEff extends Effect {

    private int pattern;
    private Expression<Player> player;
    private boolean allow;

    static {
        Skript.registerEffect(CameraStateEff.class, "(1:(allow)|2:(deny)) betterperspective camera for %player%");
    }

    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        switch (pattern) {
            case 1 -> allow = true;
            case 2 -> allow = false;
        }
        BetterPerspectiveAddon.setCameraState(p, allow);
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