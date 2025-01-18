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

public class AddDefaultRPCEff extends Effect {

    private Expression<String> title;
    private Expression<Player> player;

    static {
        Skript.registerEffect(AddDefaultRPCEff.class, "create Discord RPC named %string% for %player%");
    }

    @Override
    protected void execute(Event event) {
        String t = title.getSingle(event);
        Player p = player.getSingle(event);

        LabyRPCManager.addDefaultPresence(p, t);

    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        title = (Expression<String>) expressions[0];
        player = (Expression<Player>) expressions[1];
        return true;
    }
}