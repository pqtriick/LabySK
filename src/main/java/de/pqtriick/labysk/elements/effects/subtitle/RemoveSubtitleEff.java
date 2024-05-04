package de.pqtriick.labysk.elements.effects.subtitle;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.Subtitle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Remove Subtitle of player")
@Description("Removes the subtitle of the player")
@Examples({"remove subtitle of player"})
public class RemoveSubtitleEff extends Effect {

    private Expression<Player> player;

    static {
        Skript.registerEffect(RemoveSubtitleEff.class, "remove subtitle of %player%");
    }

    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        for (Player all : Bukkit.getOnlinePlayers()) {
            Subtitle.sendSubtitle(all, p.getUniqueId(), null, 0.8);
        }

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
