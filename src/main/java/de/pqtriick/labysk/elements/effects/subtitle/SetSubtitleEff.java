package de.pqtriick.labysk.elements.effects.subtitle;


import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.display.LabySubtitle;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Set the Subtitle of player")
@Description("Sets the subtitle to the given text. Accepted sizes: 0.8-1.6")
@Examples({"set the subtitle of player to \"Hello\" with size 0.8"})
public class SetSubtitleEff extends Effect {

    private Expression<Player> player;
    private Expression<String> text;
    private Expression<Double> size;
    private Expression<Player> reciever;

    static {
        Skript.registerEffect(SetSubtitleEff.class, "set the subtitle of %player% to %string% with size %double% for %player%");
    }

    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        String subtitle = text.getSingle(event);
        Double s = size.getSingle(event);
        Player r = reciever.getSingle(event);
        LabySubtitle.sendSubtitle(r, p, subtitle, s);
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        text = (Expression<String>) expressions[1];
        size = (Expression<Double>) expressions[2];
        reciever = (Expression<Player>) expressions[3];
        return true;
    }
}
