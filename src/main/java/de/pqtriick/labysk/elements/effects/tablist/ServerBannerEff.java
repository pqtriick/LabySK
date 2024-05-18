package de.pqtriick.labysk.elements.effects.tablist;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.LabySK;
import de.pqtriick.labysk.laby.ServerBanner;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.scheduler.BukkitTask;

import javax.annotation.Nullable;
import java.util.function.Consumer;

@Name("Set server banner (Link to image)")
@Description("Sets the Server Banner which is displayed over the tablist")
@Examples({"send server banner \"link\" to player"})

public class ServerBannerEff extends Effect {

    private Expression<String> imageLink;
    private Expression<Player> player;

    static {
        Skript.registerEffect(ServerBannerEff.class, "send server banner %string% to %player%");
    }

    @Override
    protected void execute(Event event) {
        String link = imageLink.getSingle(event);
        Player p = player.getSingle(event);
        Bukkit.getScheduler().runTaskLaterAsynchronously(LabySK.getLabySK(), new Consumer<BukkitTask>() { //Need delay to send packets
            @Override
            public void accept(BukkitTask bukkitTask) {
                ServerBanner.sendBanner(p, link);
            }
        }, 20);
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        imageLink = (Expression<String>) expressions[0];
        player = (Expression<Player>) expressions[1];
        return true;
    }
}
