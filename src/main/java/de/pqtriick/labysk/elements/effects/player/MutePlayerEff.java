package de.pqtriick.labysk.elements.effects.player;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.player.LabyVoice;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class MutePlayerEff extends Effect {

    private Expression<Player> player;
    private Expression<String> reason;
    private Expression<Integer> time;

    static {
        Skript.registerEffect(MutePlayerEff.class, "mute %player% from voice chat due to %string% for %integer% minutes");
    }

    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        String r = reason.getSingle(event);
        Integer t = time.getSingle(event);
        LabyVoice.mute(p,r,t);
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        reason = (Expression<String>) expressions[1];
        time = (Expression<Integer>) expressions[2];
        return true;
    }
}