package de.pqtriick.labysk.elements.effects.inputPrompt;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.inputprompt.LabyInputPrompt;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import javax.annotation.Nullable;
public class OpenInputEff extends Effect {
    static {
        Skript.registerEffect(OpenInputEff.class, "open inputprompt with id %string% for %player%");
    }
    private Expression<String> id;
    private Expression<Player> player;
    @Override
    protected void execute(Event event) {
        String i = id.getSingle(event);
        Player p = player.getSingle(event);
        LabyInputPrompt.sendPrompt(i, p);
    }
    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }
    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        id = (Expression<String>) expressions[0];
        player = (Expression<Player>) expressions[1];
        return true;
    }
}