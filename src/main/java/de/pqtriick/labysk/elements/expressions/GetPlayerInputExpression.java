package de.pqtriick.labysk.elements.expressions;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.inputprompt.LabyInputPrompt;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import javax.annotation.Nullable;
public class GetPlayerInputExpression extends SimpleExpression<String> {
    static {
        Skript.registerExpression(GetPlayerInputExpression.class, String.class, ExpressionType.COMBINED, "input of %player%");
    }
    private Expression<Player> player;
    @Override
    protected @Nullable String[] get(Event event) {
        Player p = player.getSingle(event);
        if (p != null) {
            String input = String.valueOf(LabyInputPrompt.getInput(p));
            if (input != null) {
                return new String[]{input};
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
        return "Expression";
    }
    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        return true;
    }
}