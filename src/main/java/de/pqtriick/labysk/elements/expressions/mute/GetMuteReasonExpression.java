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
public class GetMuteReasonExpression extends SimpleExpression<String> {
    static {
        Skript.registerExpression(GetMuteReasonExpression.class, String.class, ExpressionType.COMBINED, " reason of voicechat mute of %player%");
    }
    private Expression<Player> player;
    @Override
    protected @Nullable String[] get(Event event) {
        Player p = player.getSingle(event);
        if (p != null) {
            if (LabyVoice.muteReason.get(p) != null) {
                String reason = LabyVoice.muteReason.get(p);
                return new String[]{reason};
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
        return null;
    }
    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        return true;
    }
}