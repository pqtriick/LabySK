package de.pqtriick.labysk.elements.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.player.LabyPlayer;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class GetLabymodVersionExpression extends SimpleExpression<String> {

    static {
        Skript.registerExpression(GetLabymodVersionExpression.class, String.class, ExpressionType.COMBINED, "labymod version of %player%");
    }

    private Expression<Player> player;

    @Override
    protected String[] get(Event event) {
        Player p = player.getSingle(event);
        if (p != null) {
            LabyModPlayer labyPlayer = LabyPlayer.getPlayer(p);
            if (labyPlayer != null) {
                String version = LabyPlayer.getLabyVersion(labyPlayer);
                return new String[]{version};
            }
        }
        return null;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        return true;
    }
}