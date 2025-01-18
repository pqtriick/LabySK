package de.pqtriick.labysk.elements.effects.discord;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.discord.LabyRPCManager;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class AddEndTimeRPCEff extends Effect {
    private Expression<Player> player;
    private Expression<String> title;
    private Expression<Integer> endTime;

    static {
        Skript.registerEffect(AddEndTimeRPCEff.class, "create Discord RPC named %string% with end time of %integer% minutes for %player%");
    }

    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        String t = title.getSingle(event);
        Integer e = endTime.getSingle(event);
        LabyRPCManager.addPresenceEndTime(p, t, e);
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        title = (Expression<String>) expressions[0];
        endTime = (Expression<Integer>) expressions[1];
        player = (Expression<Player>) expressions[2];
        return true;
    }
}
