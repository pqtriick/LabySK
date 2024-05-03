package de.pqtriick.labysk.elements.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.PlayingGamemode;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Show playing gamemode")
@Description("Shows the playing gamemode to all labymod friends in the top right corner if activated in profile settings")
@Examples({"make player send playing gamemode with name \"Bedwars\""})
public class PlayingGamemodeEff extends Effect {

    static {
        Skript.registerEffect(PlayingGamemodeEff.class, "make %player% send playing gamemode with name %string%");
    }

    Expression<Player> player;
    Expression<String> gamemode;

    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        String text = gamemode.getSingle(event);
        PlayingGamemode.sendGamemode(p, true, text);



    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        gamemode = (Expression<String>) expressions[1];
        return true;
    }
}
