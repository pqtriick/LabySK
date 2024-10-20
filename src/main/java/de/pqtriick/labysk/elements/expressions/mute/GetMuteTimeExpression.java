package de.pqtriick.labysk.elements.expressions.mute;


import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.player.LabyVoice;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class GetMuteTimeExpression extends SimpleExpression<Integer> {

    static {
        Skript.registerExpression(GetMuteTimeExpression.class, Integer.class, ExpressionType.COMBINED, " remaining voicechat mute time of %player%");
    }

    private Expression<Player> player;

    @Override
    protected @Nullable Integer[] get(Event event) {
        Player p = player.getSingle(event);
        if (p != null) {
            if (LabyVoice.mutedPlayers.get(p) != null) {
                Integer time = Integer.valueOf((int) (LabyVoice.mutedPlayers.get(p) /60000L));
                return new Integer[]{time};
            }
        }
        return null;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends Integer> getReturnType() {
        return Integer.class;
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
